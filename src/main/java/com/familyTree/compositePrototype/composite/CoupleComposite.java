package com.familyTree.compositePrototype.composite;

import java.util.Set;

public interface CoupleComposite {

	public String show() ; 
	public CoupleComposite getRealChild(); 
	public Set<CoupleComposite> getSiblings(); 
	public CoupleComposite getParents(); 
	public void setParents(CoupleComposite root); 
	public String getSpacing(); 
	public void setSpacing(String spacing); 
	public boolean equals(Object cc);
	public int hashCode(); 
	
	
}
