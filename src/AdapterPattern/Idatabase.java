/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package AdapterPattern;

import IteratorPackage.Collection;
import Tasks.Itasks;
import volunteermanagement.Volunteer;

/**
 *
 * @author abeer
 */
public interface Idatabase {
    void SaveVolunteers(Collection<Volunteer> data);
    Collection<Volunteer> LoadVolunteers();
    void SaveTasks(Collection<Itasks> data);
    Collection<Itasks> LoadTasks();
    
    void InsertTask(Itasks task);
    void InsertVolunteer(Volunteer v);
    
    void DeleteTask(Itasks task);
    void DeleteVolunteer(Volunteer v);
    
    void UpdateTask(String taskCode, Itasks newTask);
    void UpdateVolunteer(String id, Volunteer newVol);
    }
