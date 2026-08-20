/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IteratorPackage;

import volunteermanagement.Enums.TaskSkills;

/**
 *
 * @author abeer
 */
public class CriticalSkillCondition implements Icondition<TaskSkills>{

    @Override
    public boolean IsDesired(TaskSkills t) {
        return t.GetIsCritical();
    }
    
}
