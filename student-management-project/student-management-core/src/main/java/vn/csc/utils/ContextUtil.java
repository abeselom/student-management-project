package vn.csc.utils;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

public class ContextUtil {
	public InitialContext getInitialContext() {
		InitialContext initialContext = null;
		try {
			Hashtable<String, String> hashTable = new Hashtable<String, String>();
			hashTable.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
			hashTable.put(Context.PROVIDER_URL, "t3://localhost:7001");
			initialContext = new InitialContext(hashTable);
		} catch (Exception e) {
			System.err.println(e.getMessage().toString());
		}
		return initialContext;
	}
}
