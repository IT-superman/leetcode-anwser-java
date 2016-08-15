package com.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

/**
 * 
 * @author samsung
 *Design a data structure that supports all following operations in average O(1) time.

Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
Example:

// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();
 */
public class InsertDeleteGetRandomDuplicates381 {
	
	private Map<Integer,Set<Integer>> valToIndexMap = new HashMap<Integer,Set<Integer>>();
	private List<Integer> valList = new ArrayList<Integer>();
	private int bitCount = 0;
	
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
    	boolean isPresent = valToIndexMap.containsKey(val);
    	int index = valList.size();
    	valList.add(val);
    	if (isPresent) {
			valToIndexMap.get(val).add(index);
		}else {
			Set<Integer> indexSet = new HashSet<Integer>();
			indexSet.add(index);
			valToIndexMap.put(val, indexSet);
		}
    	int eleSize = valList.size();
    	String tempStr = String.valueOf(eleSize);
    	bitCount = tempStr.length();
    	return (!isPresent);
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
    	if (!(valToIndexMap.containsKey(val))) {
			return false;
		}
    	int lastIndex = valList.size()-1;
    	int lastVal = valList.get(lastIndex);
    	valList.remove(lastIndex);
    	valToIndexMap.get(lastVal).remove(lastIndex);
    	if (valToIndexMap.get(lastVal).isEmpty()) {
    		valToIndexMap.remove(lastVal);
		}
    	if (lastVal!=val) {
			Object[]indexArr = valToIndexMap.get(val).toArray();
    		int valIndex = (Integer)indexArr[0];
    		valList.set(valIndex, lastVal);
    		valToIndexMap.get(val).remove(valIndex);
    		if (valToIndexMap.get(val).isEmpty()) {
    			valToIndexMap.remove(val);
			}
    		if (valToIndexMap.containsKey(lastVal)) {
    			valToIndexMap.get(lastVal).add(valIndex);
			}else {
				HashSet<Integer> newLastValIndexSet = new HashSet<Integer>();
				newLastValIndexSet.add(valIndex);
				valToIndexMap.put(lastVal, newLastValIndexSet);
			}
    		
		}
    	int eleSize = valList.size();
    	String tempStr = String.valueOf(eleSize);
    	bitCount = tempStr.length();
    	return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
    	double dRandom = Math.random();
        int randomRange = (int)(dRandom*Math.pow(10, bitCount));
        int nIndex = randomRange%valList.size();
        return valList.get(nIndex);
    }
	
	@Test
	public void testHashCode(){
		Map<Integer,Integer> coll = new IdentityHashMap<Integer,Integer>();
		
		int value = 5;
		
		Integer hash1 = new Integer(Integer.hashCode(value)).hashCode();
		Integer hash2 = new Integer(Integer.hashCode(value)).hashCode() ;
		coll.put(hash1, value);
		coll.put(hash2, value);
//		Integer objectVal = Integer.hashCode(value);
//		coll.remove(objectVal);
		for (Entry<Integer, Integer> entry : coll.entrySet()) {
			System.out.println("==key-->"+entry.getKey()+"==>value-->"+entry.getValue());
		}
		
	}
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
