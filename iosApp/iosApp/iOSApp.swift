//
//  iOSApp.swift
//  iosApp
//
//  Created by Doğan Can Kılıç on 4.09.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared


@main
struct iOSApp: App {
    
        // KMM - Koin Call
    init() {
        KoinKt.doInitKoin()
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
