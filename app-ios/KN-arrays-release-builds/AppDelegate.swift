//
//  AppDelegate.swift
//  KN-arrays-release-builds
//
//  Created by TesMath on 16.07.20.
//  Copyright © 2020 TesMath. All rights reserved.
//

import UIKit
import KNArrays

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

    var window: UIWindow?

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        // Override point for customization after application launch.
        
        doTests()
        
        return true
    }
    
    func doTests() {
        let array1 = ArraysConstructor(int1: 1, int2: 2)
        array1.log()
        array1.set(int1: 3, int2: 4)
        array1.log()
        
        print("--------------------------------")
        let array2 = ArraysDefault(int1: 1, int2: 2)
        array2.log()
        array2.set(int1: 3, int2: 4)
        array2.log()
 
        print("--------------------------------")
        let array3 = ArraysInitBlock(int1: 1, int2: 2)
        array3.log()
        array3.set(int1: 3, int2: 4)
        array3.log()
        
    }
}

