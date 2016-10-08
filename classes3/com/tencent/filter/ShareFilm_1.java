package com.tencent.filter;

public class ShareFilm_1
  extends BaseFilter
{
  public ShareFilm_1()
  {
    super(GLSLRender.SHARE_SHADER_FILM_1, "share_film.jpg");
    addParam(new Param.Float2fParam("randomCoord2", (float)Math.random(), (float)Math.random()));
  }
  
  public void OnDrawFrameGLSL()
  {
    Param.Float2fParam localFloat2fParam = (Param.Float2fParam)getParam("randomCoord2");
    localFloat2fParam.x = ((float)Math.random());
    localFloat2fParam.y = ((float)Math.random());
    super.OnDrawFrameGLSL();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\filter\ShareFilm_1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */