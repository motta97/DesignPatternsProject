/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package utility;

/**
 *
 * @author abeer
 */
public interface IuserFactoryAdapter {
    public User CreateInstance(String type, String name, String email, String phoneNumber);
}
