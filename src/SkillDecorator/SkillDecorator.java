/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SkillDecorator;

/**
 *
 * @author Compuomart
 */
abstract class SkillDecorator implements Iskills{
    protected Iskills wrappedSkill;
    private String representedSkill;
    
    public SkillDecorator(Iskills skill){
        wrappedSkill = skill;
    }
    public boolean hasSkill(String skillName){
        return wrappedSkill.hasSkill(skillName);
    }
}

