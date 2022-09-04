import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greeting()
    let api = GetCharacterUseCase.invoke(<#T##self: GetCharacterUseCase##GetCharacterUseCase#>)

	var body: some View {
		Text(greet)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
