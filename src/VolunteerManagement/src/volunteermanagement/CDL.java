/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package volunteermanagement;

/**
 *
 * @author Compuomart
 */
public class CDL extends SkillDecorator{
    private String skillName = "CDL";
    public CDL(Iskills wrapped){
        super(wrapped);
    }
    @Override
    public String GetSkills(){
        return wrapped.GetSkills()+skillName;
    }
}
