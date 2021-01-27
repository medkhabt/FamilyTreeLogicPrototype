package com.familyTree.compositePrototype.entity;

import java.util.HashSet;
import java.util.Set;

import com.familyTree.compositePrototype.composite.CoupleComposite;

public class Couple implements CoupleComposite{
	private long id; 
	private Set<CoupleComposite> children ; 
	private CoupleComposite root; 
	private CoupleComposite realChild;
	private CoupleComposite partner; 
	private String spacing;
	
	public Couple(long id,CoupleComposite root, CoupleComposite realChild, CoupleComposite partner) {
		this.id = id;
		this.root = root;
		this.realChild = realChild;
		this.children = new HashSet<>(); 
		this.spacing = ""; 
		this.partner  = partner; 
	}
	
	public Couple(long id, CoupleComposite realChild, CoupleComposite partner) {
		this.id = id;
		this.root = new Person(0, "root");
		this.realChild = realChild;
		this.children = new HashSet<>(); 
		this.spacing = ""; 
		this.partner  = partner; 
	}
	
	
	public void addChild(CoupleComposite child) { 
		this.children.add(child);
	}
	
	public void removeChild(CoupleComposite child) {
		this.children.remove(child); 
	}

	public Set<CoupleComposite> getChildren() {
		return children;
	}

	public void setChildren(Set<CoupleComposite> children) {
		this.children = children;
	}

	public CoupleComposite getRoot() {
		return root;
	}

	public void setRoot(CoupleComposite root) {
		this.root = root;
	}

	public CoupleComposite getRealChild() {
		return realChild;
	}

	public void setRealChild(CoupleComposite realChild) {
		this.realChild = realChild;
	}
	
	public CoupleComposite getPartner() {
		return this.partner; 
	}

	public void setPartner(CoupleComposite partner) {
		this.partner = partner; 
	}
	public long getId() {
		return id;
	}

	@Override
	public String show() {
		String msgBoxWithChildren = spacing; 
		if(!this.children.isEmpty()) { 
			for(CoupleComposite child: children) {
				child.setSpacing(spacing + "\t");
				msgBoxWithChildren += "\n"+ child.getSpacing()+ child.show();
				
			}
		}
		return toString() + msgBoxWithChildren ;
	}

	@Override
	public Set<CoupleComposite> getSiblings() {
		
		return this.realChild.getSiblings();
	}

	@Override
	public CoupleComposite getParents() {
		return this.getRoot();
	}

	
	@Override
	public String toString() {
		return "Couple [id=" + id + ", realChild=" + ((Person) realChild).getName()
				+ ", partner=" + ((Person) partner).getName() + "]";
	}


	@Override
	public String getSpacing() {
		return this.spacing;
	}

	@Override
	public void setSpacing(String spacing) {
		this.spacing = spacing ;
	}

	@Override
	public void setParents(CoupleComposite root) {
		this.root = root; 
//		this.partner.setParents(root);
		this.realChild.setParents(root);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((partner == null) ? 0 : partner.hashCode());
		result = prime * result + ((realChild == null) ? 0 : realChild.hashCode());
		result = prime * result + ((root == null) ? 0 : root.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Couple other = (Couple) obj;
		if (partner == null) {
			if (other.partner != null)
				return false;
		} else if (!partner.equals(other.partner))
			return false;
		if (realChild == null) {
			if (other.realChild != null)
				return false;
		} else if (!realChild.equals(other.realChild))
			return false;
		if (root == null) {
			if (other.root != null)
				return false;
		} else if (!root.equals(other.root))
			return false;
		return true;
	} 
	
	
	
	
	
}
