/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tut.taskmanagement.model;

import java.time.LocalDateTime;

/**
 *
 * @author S2026080
 */
public class TaskResponseDto {
   private String originalUrl;
   private String shortLink;
   private LocalDateTime expirationDate;

    public TaskResponseDto() {
    }

    public TaskResponseDto(String originalUrl, String shortLink, LocalDateTime expirationDate) {
        this.originalUrl = originalUrl;
        this.shortLink = shortLink;
        this.expirationDate = expirationDate;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "UrlResponseDto{" + "originalUrl=" + originalUrl + ", shortLink=" + shortLink + ", expirationDate=" + expirationDate + '}';
    }
   
   
}
