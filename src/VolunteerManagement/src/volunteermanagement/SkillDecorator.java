/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package volunteermanagement;

/**
 *
 * @author Compuomart
 */
public abstract class SkillDecorator implements Iskills{
    protected Iskills wrapped;
    
    public SkillDecorator(Iskills skill){
        wrapped = skill;
    }
    
    public abstract String GetSkills();
}
