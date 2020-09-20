package com.nanokylin.catpawserver;

import com.nanokylin.catpawserver.controller.MainController;

/**
 * Main Class
 * Stat of Dream
 * @author Hanbings
 */
public class CatPawServer
{
    public static void main( String[] args )
    {
        MainController mainController = new MainController();
        mainController.RunCatPawServer();
    }
}
