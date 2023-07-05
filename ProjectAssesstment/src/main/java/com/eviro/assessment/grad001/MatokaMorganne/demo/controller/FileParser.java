/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.eviro.assessment.grad001.MatokaMorganne.demo.controller;

import java.io.File;
import java.net.URI;

public interface FileParser {
    void parseCSV(File csvFile);
    File convertedCSVDataToImage(String base64ImageData);
    URI createImageLink(File fileImage);
}
