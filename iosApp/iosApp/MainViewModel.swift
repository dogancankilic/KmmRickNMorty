//
//  MainViewModel.swift
//  iosApp
//
//  Created by Doğan Can Kılıç on 4.09.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

class MainViewModel: ObservableObject {
    
       @Published var name: String = " "
       @Published var imageUrl: String = " "

       
       var rickApi = GetCharacterUseCase()
       
       func loadCharacters() {
           rickApi.invoke(endPoint: "api/character/1") { result, error in
               if(result?.error != nil) {
                   print(result?.error)
               }
               else{
                   self.name = result?.data?.name ?? ""
                   self.imageUrl = result?.data?.image ?? ""
               }
              

           }
       }
    
    
}


