package NS_MOBILE_MAIN_PAGE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class s_game
  extends JceStruct
{
  static ArrayList cache_stVecGame;
  public ArrayList stVecGame;
  public long uTotalCount;
  
  public s_game()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public s_game(long paramLong, ArrayList paramArrayList)
  {
    this.uTotalCount = paramLong;
    this.stVecGame = paramArrayList;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.uTotalCount = paramJceInputStream.read(this.uTotalCount, 0, false);
    if (cache_stVecGame == null)
    {
      cache_stVecGame = new ArrayList();
      s_one_game locals_one_game = new s_one_game();
      cache_stVecGame.add(locals_one_game);
    }
    this.stVecGame = ((ArrayList)paramJceInputStream.read(cache_stVecGame, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.uTotalCount, 0);
    if (this.stVecGame != null) {
      paramJceOutputStream.write(this.stVecGame, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_MAIN_PAGE\s_game.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */