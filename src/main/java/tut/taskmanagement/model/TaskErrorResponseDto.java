/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tut.taskmanagement.model;

/**
 *
 * @author S2026080
 */
public class TaskErrorResponseDto {
   private String status;
   private String error;

    public TaskErrorResponseDto() {
    }

    public TaskErrorResponseDto(String status, String error) {
        this.status = status;
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "UrlErrorResponseDto{" + "status=" + status + ", error=" + error + '}';
    }
   
   
}
