package br.com.pathfinder.test;
import junit.framework.Assert;

import java.util.ArrayList;

import org.junit.Test;
public class Sub {
	@Test
	public void sucesso(){
		Assert.assertTrue("1" == "1");
	}
	@Test
	public void falha(){
		Assert.assertTrue(1 != 1);
	}
	@Test
	public void erro(){
		ArrayList<Integer>arrayList= new ArrayList<Integer>();
		arrayList.get(0);
	}
}
