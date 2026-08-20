/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Enums;

/**
 *
 * @author Compuomart
 */
public enum TaskSkills {
    CPR(true),
    IT(false),
    CDL(true),
    EXCEL(false),
    PPT(false),
    WORD(false),
    ASL(true);
    
    private final boolean isCritical;
    TaskSkills(boolean isCritical){
        this.isCritical = isCritical;
    }
    public boolean GetIsCritical(){
        return this.isCritical;
    }
}
