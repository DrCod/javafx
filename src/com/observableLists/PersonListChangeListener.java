package com.observableLists;

import java.util.List;

import javafx.collections.ListChangeListener;

public class PersonListChangeListener implements ListChangeListener<Person>{

	@Override
	public void onChanged(ListChangeListener.Change<? extends Person> c) {
		while(c.next()) {
			if (c.wasPermutated()){
			handlePermutatedChange(c);	
			}
			else if(c.wasUpdated()) {
				handleUpdatedChange(c);
			}
			else if(c.wasReplaced()) {
				handleReplacedChange(c);
				
			}
			else {
				if(c.wasRemoved()) {
					handleRemoved(c);
				}
				else if(c.wasAdded()) {
					 handleAdded(c);
				}
			}
		}
	}

	private void handleReplacedChange(Change<? extends Person> c) {
		System.out.println("Change type: replaced");
		handleRemoved(c);
		handleAdded(c);
	}

	private void handleAdded(Change<? extends Person> c) {
		System.out.println("Change type: Added");

		int addedSize =c.getAddedSize();
		List<? extends Person> sublist =c.getAddedSubList();
		System.out.println("Added size" + addedSize);
		System.out.println("Added range" + getRangeText(c));
		System.out.println("Added List" + sublist);
	}

	private String getRangeText(Change<? extends Person> c) {
		return "[" + c.getFrom()+","+c.getTo()+"]";
	}

	private void handleRemoved(Change<? extends Person> c) {
		System.out.println("Change type: removed");
		int removedSize =c.getRemovedSize();
		List<? extends Person> sublist = c.getRemoved();
		System.out.println("Removed Size: "+ removedSize);
		System.out.println("Removed Range: " + getRangeText(c));
		System.out.println("Removed List: "+sublist);
		
		
		
	}

	private void handleUpdatedChange(Change<? extends Person> c) {
		System.out.println("Change type: updated");
		System.out.println("Updated range: " + getRangeText(c));
		System.out.println("Updated elements are: "+c.getList().subList(c.getFrom(),c.getTo()));
		
		
	}

	private void handlePermutatedChange(Change<? extends Person> c) {
		System.out.println("Change type: permutated");
		System.out.println("Permutated range: " + getRangeText(c));
		int start =c.getFrom();
		int end =c.getTo();
		for (int oldIndex =start; oldIndex<end;oldIndex++) {
			int newIndex =c.getPermutation(oldIndex);
			System.out.println("index["+oldIndex + "] moved to" + "index[" +newIndex + "]" );
			
		}
		
	}

}
