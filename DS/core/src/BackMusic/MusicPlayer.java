package BackMusic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class MusicPlayer {
   public static Music backMusic;
   public static Music Stage1Music;
   public static Music Stage2Music;
   public static Music Stage3Music;
   public static Music Stage4Music;
   public static Music FinalStageMusic;

   // ���ι������ ���
   public static void MainBackgMusic(String path) {
      backMusic = Gdx.audio.newMusic(Gdx.files.internal(path));
      backMusic.setLooping(true);
      backMusic.play();
   }
   
   // ���ι������ ����
   public static void BackMusicStop() {
	  backMusic.setLooping(false);
	  backMusic.stop();
      backMusic.dispose();
   }
   /*
   // ��������1 ������� ���
   public static void Stage1BackMusic() {
      Stage1Music = Gdx.audio.newMusic(Gdx.files.internal("Music/Stage1.mp3"));
      Stage1Music.setLooping(true);
      Stage1Music.play();
   }

   // ��������1 ������� ����
   public static void Stage1BackMusicStop() {
	  Stage1Music.setLooping(false);
	  Stage1Music.stop();
      Stage1Music.dispose();
   }

   // ��������2 ������� ���
   public static void Stage2BackMusic() {
      Stage2Music = Gdx.audio.newMusic(Gdx.files.internal("Music/Stage2.mp3"));
      Stage2Music.setLooping(true);
      Stage2Music.play();
   }

   // ��������2 ������� ����
   public static void Stage2BackMusicStop() {
	  Stage2Music.setLooping(false);
	  Stage2Music.stop();
      Stage2Music.dispose();
   }

   // ��������3 ������� ���
   public static void Stage3BackMusic() {
      Stage3Music = Gdx.audio.newMusic(Gdx.files.internal("Music/Stage3.mp3"));
      Stage3Music.setLooping(true);
      Stage3Music.play();
   }

   // ��������3 ������� ����
   public static void Stage3BackMusicStop() {
	  Stage3Music.setLooping(false);
	  Stage3Music.stop();
      Stage3Music.dispose();
   }

   // ��������4 ������� ���
   public static void Stage4BackMusic() {
      Stage4Music = Gdx.audio.newMusic(Gdx.files.internal("Music/Stage4.mp3"));
      Stage4Music.setLooping(true);
      Stage4Music.play();
      
      
   }

   // ��������4 ������� ����
   public static void Stage4BackMusicStop() {
	  Stage4Music.setLooping(false);
	  Stage4Music.stop();
      Stage4Music.dispose();
   }

   // ���̳ν������� ����������
   public static void FinalStageBackMusic() {
      FinalStageMusic = Gdx.audio.newMusic(Gdx.files.internal("Music/HiddenStage.mp3"));
      FinalStageMusic.setLooping(true);
      FinalStageMusic.play();
   }

   // ���̳ν������� �����������
   public static void FinalStageBackMusicStop() {
	   FinalStageMusic.setLooping(false);
	   FinalStageMusic.stop();
      FinalStageMusic.dispose();
   }
   */
}