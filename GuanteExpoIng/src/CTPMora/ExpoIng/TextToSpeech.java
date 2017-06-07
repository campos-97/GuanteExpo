package CTPMora.ExpoIng;

import com.sun.speech.freetts.*;

/**
 * Created by josea on 5/22/2017.
 */
public class TextToSpeech {

    static TextToSpeech instace;

    Voice voiceKevin16;

    public TextToSpeech() {
        voiceKevin16 = new Voice("kevin16");
    }

    public static TextToSpeech getInstace(){
        if(instace == null){
            instace = new TextToSpeech();
        }
        return  instace;
    }

    public void speak(String thingsToSay){
        voiceKevin16.say(thingsToSay);
    }


}

class Voice
{
    private String name;
    private com.sun.speech.freetts.Voice systemVoice;

    public Voice(String name)
    {
        this.name = name;
        this.systemVoice = VoiceManager.getInstance().getVoice(this.name);
        this.systemVoice.allocate();
    }

    public void say(String[] thingsToSay)
    {
        for (int i = 0; i < thingsToSay.length; i++)
        {
            this.say( thingsToSay[i] );
        }
    }

    public void say(String thingToSay)
    {
        this.systemVoice.speak(thingToSay);
    }

    public void dispose()
    {
        this.systemVoice.deallocate();
    }
}