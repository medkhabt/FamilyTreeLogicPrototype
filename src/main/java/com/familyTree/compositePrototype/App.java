package com.familyTree.compositePrototype;

import com.familyTree.compositePrototype.composite.CoupleComposite;
import com.familyTree.compositePrototype.entity.Couple;
import com.familyTree.compositePrototype.entity.Person;

public class App {
    public static void main( String[] args ) {
    	
        
    	CoupleComposite a = new Person(1, "a");
    	CoupleComposite b = new Person(2, "b");
    	CoupleComposite c = new Person(3, "c");
    	CoupleComposite d = new Person(4, "d");
    	CoupleComposite e = new Person(5, "e");
    	CoupleComposite f = new Person(6, "f");
    	CoupleComposite g = new Person(7, "g");
    	CoupleComposite h = new Person(8, "h");
    	
    	
    	CoupleComposite couple1 = new Couple(1, a, b); 
    	CoupleComposite couple2 = new Couple(2, a, c, g );
    	
    	
    	
    	((Couple) couple1).addChild(couple2); 
    	((Couple) couple1).addChild(d); 
    	((Couple) couple1).addChild(e);
    	
    	d.setParents(couple1);
    	e.setParents(couple1);
    	couple2.setParents(couple1);
    	
    	((Couple) couple2).addChild(f);
    	((Couple) couple2).addChild(h);
    	
    	
    	f.setParents(couple2);
    	h.setParents(couple2);
    	
    	System.out.println(couple1.show());
    	System.out.println("***********************");
    	
    	System.out.println("Parent of c: " + c.getParents());
    	System.out.println("Parent of h: " + h.getParents());
    	System.out.println("Parent of d: " + d.getParents());
    	System.out.println("Parent of a: " + a.getParents());
    	
    	System.out.println("***********************");
    	
    	System.out.println("d siblings: ");
    	d.getSiblings().forEach((sibling) -> System.out.println("-" + sibling.toString() ));
    	

    	
    }
}
