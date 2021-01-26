package com.familyTree.compositePrototype.entity;

import java.util.HashSet;
import java.util.Set;

import com.familyTree.compositePrototype.composite.CoupleComposite;

public class Person implements CoupleComposite{
	private long id; 
	private String name;
	private String spacing; 
	private CoupleComposite root; 
	
	public Person(long id, String name) {
		this.id = id;
		this.name = name;
		this.root = new Person(0); 
		this.spacing = ""; 
	}
	public Person(long id) {
		this.id = id;
		this.name = "root";
		this.root = new Person();  
		this.spacing = ""; 
		
	}
	public Person() { 
		
	}
	
	public CoupleComposite getRoot() {
		return this.root; 
	}
	
	public void setRoot(CoupleComposite root) {
		this.root = root; 
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String show() {

		return toString();
	}
	@Override
	public CoupleComposite getRealChild() {
		return this;
	}
	@Override
	public Set<CoupleComposite> getSiblings() {
		Set<CoupleComposite> siblings = new HashSet<>(); 
		/** 
		 * the person that ask for the siblings is included in this one. 
		 */
//		((Couple) root).getChildren().forEach((child) -> siblings.add(child.getRealChild()));
		
		/**
		 * remove the asking person. 
		 */
		for(CoupleComposite child : ((Couple) root).getChildren()) { 
			if(!((Person) child.getRealChild()).getName().equals(this.getName())) { 
				siblings.add(child.getRealChild()); 
			}
		}
		
		return siblings;
	}
	@Override
	public CoupleComposite getParents() {
		return this.root;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	@Override
	public String getSpacing() {
		return this.spacing;
	}
	@Override
	public void setSpacing(String spacing) {
		this.spacing = spacing; 
	}

	@Override
	public void setParents(CoupleComposite root) {
		this.root = root; 
	}
	
	
}
