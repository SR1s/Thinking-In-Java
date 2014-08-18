package me.sr1.chapter14.examples;

import static me.sr1.util.Print.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PetCount3 {
	static class PetCounter 
	  extends LinkedHashMap<Class<? extends Pet>, Integer> {
		public PetCounter() {
			super(map(LiteralPetCreator.allTypes, 0));
		}
		public void count(Pet pet) {
			for(Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
				if(pair.getKey().isInstance(pet)) {
					put(pair.getKey(), pair.getValue() + 1);
				}
			}
		}
		public String toString() {
			StringBuilder result = new StringBuilder("{");
			for(Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
				result.append(pair.getKey().getSimpleName());
				result.append("=");
				result.append(pair.getValue());
				result.append(". ");
			}
			result.delete(result.length()-2, result.length());
			result.append("}");
			return result.toString();
		}
	}
	
	public static void main(String[] args) {
		PetCounter petCount = new PetCounter();
		for(Pet pet : Pets.createArray(20)) {
			printnb(pet.getClass().getSimpleName() + " ");
			petCount.count(pet);
		}
		print();
		print(petCount);
	}
	
	public static Map<Class<? extends Pet>, Integer> 
	  map(List<Class<? extends Pet>> list, Integer defaultVal) {
		Map<Class<? extends Pet>, Integer> map =
		  new HashMap<Class<? extends Pet>, Integer>();
		for(Class<? extends Pet> type : LiteralPetCreator.allTypes) {
			map.put(type, 0);
		}
		return map;
	}
}
