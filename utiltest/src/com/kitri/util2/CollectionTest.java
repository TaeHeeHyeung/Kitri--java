package com.kitri.util;

import java.util.*;

public class CollectionTest {

	public static void main(String[] args) {
		Collection coll= new ArrayList();
		System.out.println(coll.size());
		coll.add("ȫ�浿");
		coll.add("�̼���");
		coll.add("������");
		coll.add("������");
		coll.add(new Integer(10));
		System.out.println(coll.size());
		
		Object ob[] = coll.toArray();
		System.out.println(Arrays.toString(ob));
		
		Collection coll2= new HashSet();
		coll2.add("ȫ�浿");
		coll2.add("�̼���");
		coll2.add("������");
		coll2.add("������");
		
		Object ob2[] = coll2.toArray();
		System.out.println(Arrays.toString(ob2));
	}

}
