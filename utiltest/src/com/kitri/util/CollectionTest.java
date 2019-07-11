package com.kitri.util;

import java.util.*;

public class CollectionTest {

	public static void main(String[] args) {
		Collection coll= new ArrayList();
		System.out.println(coll.size());
		coll.add("È«±æµ¿");
		coll.add("ÀÌ¼ø½Å");
		coll.add("°­°¨Âù");
		coll.add("À±ºÀ±æ");
		coll.add(new Integer(10));
		System.out.println(coll.size());
		
		Object ob[] = coll.toArray();
		System.out.println(Arrays.toString(ob));
		
		Collection coll2= new HashSet();
		coll2.add("È«±æµ¿");
		coll2.add("ÀÌ¼ø½Å");
		coll2.add("°­°¨Âù");
		coll2.add("À±ºÀ±æ");
		
		Object ob2[] = coll2.toArray();
		System.out.println(Arrays.toString(ob2));
	}

}
