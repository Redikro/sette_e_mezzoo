import UI.*;
import UI.Screens.TitleScreen;

void main(){
    MainFrame frame = new MainFrame();
    frame.setScreen(new TitleScreen(frame));
}