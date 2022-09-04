//
//  MainObservable.swift
//  iosApp
//
//  Created by Doğan Can Kılıç on 4.09.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared
import KMPNativeCoroutinesAsync
import Combine


@Published var manga: ViewState<CharacterUiModel> = .initiate
@LazyKoin private var detailUseCase: GetCharacterUseCase

private var cancellables = Set<AnyCancellable>()

func fetchManga(endPoint: String) {
  Task {
    manga = .loading
    do {
      let nativeFlow = try await asyncFunction(for: detailUseCase.invoke(endPoint: endPoint))
      let stream = asyncStream(for: nativeFlow)
      for try await value in stream {
        if let manga = value, value != nil {
          self.manga = .success(data: manga)
        } else {
          self.manga = .empty
        }
      }
    } catch {
      manga = .error(error: error)
    }
  }
}
