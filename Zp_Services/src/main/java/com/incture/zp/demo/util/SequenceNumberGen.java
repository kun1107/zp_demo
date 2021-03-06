package com.incture.zp.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.incture.zp.demo.entity.SequenceNumber;

public class SequenceNumberGen {
	private static SequenceNumberGen sequenceNumberGenerator;

	SequenceNumber sequenceNumber = null;
	private static int oldRunningNumber = 0;
	private static String oldRefCode = "";

	public SequenceNumberGen() {
	}

	public static synchronized SequenceNumberGen getInstance() {
		if (sequenceNumberGenerator == null)
			sequenceNumberGenerator = new SequenceNumberGen();
		return sequenceNumberGenerator;
	}

	/**
	 * Generates a code in CCCCXXYYYYMMNNNN format, where CCCC is Company Code,
	 * XX is Transaction Type, YYYY is year, MM is Month, NNNN is the number
	 * generated by this function. Input field <code>referenceCode</code> is
	 * CCCCXXYYYYMM and <code>noOfDigits</code> indicate size of NNNN. Function
	 * uses a variable of hash map data structure with application scope, where
	 * referenceCode parameter is the key and running number(sequential,
	 * incremented by 1, starting from 0) is the value. Function is thread-safe,
	 * map variable is lazy loaded once, and value persist to relevant table in
	 * CEDB on every request.
	 */
	public synchronized String getNextSeqNumber(String referenceCode, Integer noOfDigits, Session session) {
		Criteria criteria = session.createCriteria(SequenceNumber.class);
		criteria.add(Restrictions.eq("referenceCode", referenceCode));

		sequenceNumber = (SequenceNumber) criteria.uniqueResult();
		int runningNumber;
		if (sequenceNumber != null) {
			session.refresh(sequenceNumber);
			runningNumber = updateRecord(sequenceNumber, session);
			if (oldRunningNumber == runningNumber && oldRefCode.equals(referenceCode)) {// to
																						// avoid
																						// duplicates
				Criteria criteria1 = session.createCriteria(SequenceNumber.class);
				criteria1.add(Restrictions.eq("referenceCode", referenceCode));

				sequenceNumber = (SequenceNumber) criteria1.uniqueResult();
				runningNumber = updateRecord(sequenceNumber, session);
			}
		} else {
			runningNumber = pushRecord(referenceCode, session);
		}
		oldRunningNumber = runningNumber;
		oldRefCode = referenceCode;
		return buildSeqNumber(referenceCode, noOfDigits, runningNumber);
	}

	private String buildSeqNumber(String referenceCode, Integer noOfDigits, int runningNumber) {
		StringBuilder sb = new StringBuilder(noOfDigits);
		sb.append(runningNumber);
		int noOfPads = noOfDigits - sb.length();
		while (noOfPads-- > 0) {
			sb.insert(0, '0');
		}
		sb.insert(0, referenceCode);
		return sb.toString();
	}

	private int pushRecord(String referenceCode, Session session) {
		SequenceNumber sequenceNumber = new SequenceNumber(referenceCode, 1);
		// NOTE: Hard coding to zero
		session.persist(sequenceNumber);
		return sequenceNumber.getRunningNumber();
	}

	private int updateRecord(SequenceNumber sequenceNumber, Session session) {
		int runningnumber = 0;
		sequenceNumber.setRunningNumber(sequenceNumber.getRunningNumber() + 1);

		session.persist(sequenceNumber);
		session.flush();
		session.refresh(sequenceNumber);
		Criteria criteria = session.createCriteria(SequenceNumber.class);
		criteria.add(Restrictions.eq("referenceCode", sequenceNumber.getReferenceCode()));

		SequenceNumber retDto1 = (SequenceNumber) criteria.uniqueResult();
		if (retDto1 != null) {
			runningnumber = retDto1.getRunningNumber();
		}
		return runningnumber;
	}
	
	public String getString(){
		Date currentDate = new Date();
		SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
		return df.format(currentDate);
	}
}
