/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SkillDecorator;

/**
 *
 * @author Compuomart
 */
class CPRdecorator extends SkillDecorator{
    private String representedSkill = "CPR";
    public CPRdecorator(Iskills skill){
        super(skill);
    }
    @Override
    public boolean hasSkill(String s) {
        if(s.equals(this.representedSkill)){
            return true;
        }
        else{
            return wrappedSkill.hasSkill(s);
        }
    }
    
}