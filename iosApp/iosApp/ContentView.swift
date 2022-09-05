import SwiftUI
import shared

struct ContentView: View {

    @ObservedObject private var viewModel = MainViewModel()


    var body: some View {
        Text(viewModel.name).onAppear{
            viewModel.loadCharacters()
        }
        AsyncImage(url: URL(string: viewModel.imageUrl))
            .clipShape(RoundedRectangle(cornerRadius: 20))

    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
