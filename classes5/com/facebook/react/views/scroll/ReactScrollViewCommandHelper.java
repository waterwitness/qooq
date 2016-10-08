package com.facebook.react.views.scroll;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import java.util.Map;
import javax.annotation.Nullable;

public class ReactScrollViewCommandHelper
{
  public static final int COMMAND_SCROLL_TO = 1;
  public static final int COMMAND_SCROLL_WITHOUT_ANIMATION_TO = 2;
  
  public static Map<String, Integer> getCommandsMap()
  {
    return MapBuilder.of("scrollTo", Integer.valueOf(1), "scrollWithoutAnimationTo", Integer.valueOf(2));
  }
  
  public static <T> void receiveCommand(ScrollCommandHandler<T> paramScrollCommandHandler, T paramT, int paramInt, @Nullable ReadableArray paramReadableArray)
  {
    Assertions.assertNotNull(paramScrollCommandHandler);
    Assertions.assertNotNull(paramT);
    Assertions.assertNotNull(paramReadableArray);
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", new Object[] { Integer.valueOf(paramInt), paramScrollCommandHandler.getClass().getSimpleName() }));
    case 1: 
      paramScrollCommandHandler.scrollTo(paramT, new ScrollToCommandData(Math.round(PixelUtil.toPixelFromDIP(paramReadableArray.getDouble(0))), Math.round(PixelUtil.toPixelFromDIP(paramReadableArray.getDouble(1)))));
      return;
    }
    paramScrollCommandHandler.scrollWithoutAnimationTo(paramT, new ScrollToCommandData(Math.round(PixelUtil.toPixelFromDIP(paramReadableArray.getDouble(0))), Math.round(PixelUtil.toPixelFromDIP(paramReadableArray.getDouble(1)))));
  }
  
  public static abstract interface ScrollCommandHandler<T>
  {
    public abstract void scrollTo(T paramT, ReactScrollViewCommandHelper.ScrollToCommandData paramScrollToCommandData);
    
    public abstract void scrollWithoutAnimationTo(T paramT, ReactScrollViewCommandHelper.ScrollToCommandData paramScrollToCommandData);
  }
  
  public static class ScrollToCommandData
  {
    public final int mDestX;
    public final int mDestY;
    
    ScrollToCommandData(int paramInt1, int paramInt2)
    {
      this.mDestX = paramInt1;
      this.mDestY = paramInt2;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\scroll\ReactScrollViewCommandHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */