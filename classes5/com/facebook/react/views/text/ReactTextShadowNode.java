package com.facebook.react.views.text;

import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.facebook.common.logging.FLog;
import com.facebook.csslayout.CSSConstants;
import com.facebook.csslayout.CSSNode;
import com.facebook.csslayout.CSSNode.MeasureFunction;
import com.facebook.csslayout.MeasureOutput;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactProp;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIViewOperationQueue;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class ReactTextShadowNode
  extends LayoutShadowNode
{
  private static final String INLINE_IMAGE_PLACEHOLDER = "I";
  @VisibleForTesting
  public static final String PROP_TEXT = "text";
  private static final CSSNode.MeasureFunction TEXT_MEASURE_FUNCTION = new CSSNode.MeasureFunction()
  {
    public void measure(CSSNode paramAnonymousCSSNode, float paramAnonymousFloat, MeasureOutput paramAnonymousMeasureOutput)
    {
      ReactTextShadowNode localReactTextShadowNode = (ReactTextShadowNode)paramAnonymousCSSNode;
      paramAnonymousCSSNode = ReactTextShadowNode.sTextPaintInstance;
      Spannable localSpannable = localReactTextShadowNode.mPreparedSpannableText;
      if (localSpannable == null)
      {
        if (FLog.isLoggable(6)) {
          FLog.e("Exception", "Spannable element has not been prepared in onBeforeLayout");
        }
        return;
      }
      BoringLayout.Metrics localMetrics = BoringLayout.isBoring(localSpannable, paramAnonymousCSSNode);
      float f;
      if (localMetrics == null)
      {
        f = Layout.getDesiredWidth(localSpannable, paramAnonymousCSSNode);
        label59:
        if ((localMetrics != null) || ((!CSSConstants.isUndefined(paramAnonymousFloat)) && ((CSSConstants.isUndefined(f)) || (f > paramAnonymousFloat)))) {
          break label276;
        }
        paramAnonymousCSSNode = new StaticLayout(localSpannable, paramAnonymousCSSNode, (int)Math.ceil(f), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
        label110:
        paramAnonymousMeasureOutput.height = paramAnonymousCSSNode.getHeight();
        paramAnonymousMeasureOutput.width = paramAnonymousCSSNode.getWidth();
        if ((localReactTextShadowNode.mNumberOfLines != -1) && (localReactTextShadowNode.mNumberOfLines < paramAnonymousCSSNode.getLineCount())) {
          paramAnonymousMeasureOutput.height = paramAnonymousCSSNode.getLineBottom(localReactTextShadowNode.mNumberOfLines - 1);
        }
        if (localReactTextShadowNode.mLineHeight != -1) {
          if (localReactTextShadowNode.mNumberOfLines == -1) {
            break label344;
          }
        }
      }
      label276:
      label344:
      for (int i = Math.min(localReactTextShadowNode.mNumberOfLines, paramAnonymousCSSNode.getLineCount());; i = paramAnonymousCSSNode.getLineCount())
      {
        f = PixelUtil.toPixelFromSP(localReactTextShadowNode.mLineHeight);
        paramAnonymousMeasureOutput.height = (i * f);
        if ((!CSSConstants.isUndefined(paramAnonymousFloat)) && (paramAnonymousMeasureOutput.width >= paramAnonymousFloat)) {
          break;
        }
        paramAnonymousMeasureOutput.width += ReactTextShadowNode.sExtendWidth;
        if ((CSSConstants.isUndefined(paramAnonymousFloat)) || (paramAnonymousMeasureOutput.width <= paramAnonymousFloat)) {
          break;
        }
        paramAnonymousMeasureOutput.width = paramAnonymousFloat;
        return;
        f = NaN.0F;
        break label59;
        if ((localMetrics != null) && ((CSSConstants.isUndefined(paramAnonymousFloat)) || (localMetrics.width <= paramAnonymousFloat)))
        {
          paramAnonymousCSSNode = BoringLayout.make(localSpannable, paramAnonymousCSSNode, localMetrics.width, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, localMetrics, true);
          break label110;
        }
        paramAnonymousCSSNode = new StaticLayout(localSpannable, paramAnonymousCSSNode, (int)paramAnonymousFloat, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
        break label110;
      }
    }
  };
  public static final int UNSET = -1;
  public static int sExtendWidth;
  private static final TextPaint sTextPaintInstance = new TextPaint();
  private int mBackgroundColor;
  private int mColor;
  protected boolean mContainsImages = false;
  @Nullable
  private String mFontFamily = null;
  protected int mFontSize = -1;
  private int mFontStyle = -1;
  private int mFontWeight = -1;
  private boolean mIsBackgroundColorSet = false;
  private boolean mIsColorSet = false;
  private final boolean mIsVirtual;
  private int mLineHeight = -1;
  protected int mNumberOfLines = -1;
  @Nullable
  private Spannable mPreparedSpannableText;
  @Nullable
  private String mText = null;
  
  static
  {
    sExtendWidth = 0;
    sTextPaintInstance.setFlags(1);
  }
  
  public ReactTextShadowNode(boolean paramBoolean)
  {
    this.mIsVirtual = paramBoolean;
    if (!paramBoolean) {
      setMeasureFunction(TEXT_MEASURE_FUNCTION);
    }
  }
  
  private static final void buildSpannedFromImageNode(ReactTextInlineImageShadowNode paramReactTextInlineImageShadowNode, SpannableStringBuilder paramSpannableStringBuilder, List<SetSpanOperation> paramList)
  {
    int i = paramSpannableStringBuilder.length();
    paramReactTextInlineImageShadowNode = new TextInlineImageSpan(paramReactTextInlineImageShadowNode.getThemedContext().getResources(), (int)PixelUtil.toDIPFromPixel(paramReactTextInlineImageShadowNode.getStyleHeight()), (int)PixelUtil.toDIPFromPixel(paramReactTextInlineImageShadowNode.getStyleWidth()), paramReactTextInlineImageShadowNode.getUri(), paramReactTextInlineImageShadowNode.getDraweeControllerBuilder(), paramReactTextInlineImageShadowNode.getCallerContext());
    paramSpannableStringBuilder.append("I");
    paramList.add(new SetSpanOperation(i, paramSpannableStringBuilder.length(), paramReactTextInlineImageShadowNode));
  }
  
  private static final void buildSpannedFromTextCSSNode(ReactTextShadowNode paramReactTextShadowNode, SpannableStringBuilder paramSpannableStringBuilder, List<SetSpanOperation> paramList)
  {
    int j = paramSpannableStringBuilder.length();
    if (paramReactTextShadowNode.mText != null) {
      paramSpannableStringBuilder.append(paramReactTextShadowNode.mText);
    }
    int i = 0;
    int k = paramReactTextShadowNode.getChildCount();
    if (i < k)
    {
      ReactShadowNode localReactShadowNode = paramReactTextShadowNode.getChildAt(i);
      if ((localReactShadowNode instanceof ReactTextShadowNode)) {
        buildSpannedFromTextCSSNode((ReactTextShadowNode)localReactShadowNode, paramSpannableStringBuilder, paramList);
      }
      for (;;)
      {
        ((ReactShadowNode)localReactShadowNode).markUpdateSeen();
        i += 1;
        break;
        if (!(localReactShadowNode instanceof ReactTextInlineImageShadowNode)) {
          break label96;
        }
        buildSpannedFromImageNode((ReactTextInlineImageShadowNode)localReactShadowNode, paramSpannableStringBuilder, paramList);
      }
      label96:
      throw new IllegalViewOperationException("Unexpected view type nested under text node: " + localReactShadowNode.getClass());
    }
    i = paramSpannableStringBuilder.length();
    if (i >= j)
    {
      if (paramReactTextShadowNode.mIsColorSet) {
        paramList.add(new SetSpanOperation(j, i, new ForegroundColorSpan(paramReactTextShadowNode.mColor)));
      }
      if (paramReactTextShadowNode.mIsBackgroundColorSet) {
        paramList.add(new SetSpanOperation(j, i, new BackgroundColorSpan(paramReactTextShadowNode.mBackgroundColor)));
      }
      if (paramReactTextShadowNode.mFontSize != -1) {
        paramList.add(new SetSpanOperation(j, i, new AbsoluteSizeSpan(paramReactTextShadowNode.mFontSize)));
      }
      if ((paramReactTextShadowNode.mFontStyle != -1) || (paramReactTextShadowNode.mFontWeight != -1) || (paramReactTextShadowNode.mFontFamily != null)) {
        paramList.add(new SetSpanOperation(j, i, new CustomStyleSpan(paramReactTextShadowNode.mFontStyle, paramReactTextShadowNode.mFontWeight, paramReactTextShadowNode.mFontFamily, paramReactTextShadowNode.getThemedContext().getAssets())));
      }
      paramList.add(new SetSpanOperation(j, i, new ReactTagSpan(paramReactTextShadowNode.getReactTag())));
    }
  }
  
  protected static final Spannable fromTextCSSNode(ReactTextShadowNode paramReactTextShadowNode)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    ArrayList localArrayList = new ArrayList();
    buildSpannedFromTextCSSNode(paramReactTextShadowNode, localSpannableStringBuilder, localArrayList);
    if (paramReactTextShadowNode.mFontSize == -1) {
      localSpannableStringBuilder.setSpan(new AbsoluteSizeSpan((int)Math.ceil(PixelUtil.toPixelFromSP(14.0F))), 0, localSpannableStringBuilder.length(), 17);
    }
    paramReactTextShadowNode.mContainsImages = false;
    int i = localArrayList.size() - 1;
    while (i >= 0)
    {
      SetSpanOperation localSetSpanOperation = (SetSpanOperation)localArrayList.get(i);
      if ((localSetSpanOperation.what instanceof TextInlineImageSpan)) {
        paramReactTextShadowNode.mContainsImages = true;
      }
      localSetSpanOperation.execute(localSpannableStringBuilder);
      i -= 1;
    }
    return localSpannableStringBuilder;
  }
  
  private static int parseNumericFontWeight(String paramString)
  {
    if ((paramString.length() == 3) && (paramString.endsWith("00")) && (paramString.charAt(0) <= '9') && (paramString.charAt(0) >= '1')) {
      return (paramString.charAt(0) - '0') * 100;
    }
    return -1;
  }
  
  public boolean isVirtual()
  {
    return this.mIsVirtual;
  }
  
  public boolean isVirtualAnchor()
  {
    return !this.mIsVirtual;
  }
  
  protected void markUpdated()
  {
    super.markUpdated();
    if (!this.mIsVirtual) {
      super.dirty();
    }
  }
  
  public void onBeforeLayout()
  {
    if (this.mIsVirtual) {
      return;
    }
    this.mPreparedSpannableText = fromTextCSSNode(this);
    markUpdated();
  }
  
  public void onCollectExtraUpdates(UIViewOperationQueue paramUIViewOperationQueue)
  {
    if (this.mIsVirtual) {}
    do
    {
      return;
      super.onCollectExtraUpdates(paramUIViewOperationQueue);
    } while (this.mPreparedSpannableText == null);
    ReactTextUpdate localReactTextUpdate = new ReactTextUpdate(this.mPreparedSpannableText, -1, this.mContainsImages);
    paramUIViewOperationQueue.enqueueUpdateExtraData(getReactTag(), localReactTextUpdate);
  }
  
  @ReactProp(name="backgroundColor")
  public void setBackgroundColor(Integer paramInteger)
  {
    if (!isVirtualAnchor()) {
      if (paramInteger == null) {
        break label38;
      }
    }
    label38:
    for (boolean bool = true;; bool = false)
    {
      this.mIsBackgroundColorSet = bool;
      if (this.mIsBackgroundColorSet) {
        this.mBackgroundColor = paramInteger.intValue();
      }
      markUpdated();
      return;
    }
  }
  
  @ReactProp(name="color")
  public void setColor(@Nullable Integer paramInteger)
  {
    if (paramInteger != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.mIsColorSet = bool;
      if (this.mIsColorSet) {
        this.mColor = paramInteger.intValue();
      }
      markUpdated();
      return;
    }
  }
  
  @ReactProp(name="fontFamily")
  public void setFontFamily(@Nullable String paramString)
  {
    this.mFontFamily = paramString;
    markUpdated();
  }
  
  @ReactProp(defaultFloat=-1.0F, name="fontSize")
  public void setFontSize(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat != -1.0F) {
      f = (float)Math.ceil(PixelUtil.toPixelFromSP(paramFloat));
    }
    this.mFontSize = ((int)f);
    markUpdated();
  }
  
  @ReactProp(name="fontStyle")
  public void setFontStyle(@Nullable String paramString)
  {
    int i = -1;
    if ("italic".equals(paramString)) {
      i = 2;
    }
    for (;;)
    {
      if (i != this.mFontStyle)
      {
        this.mFontStyle = i;
        markUpdated();
      }
      return;
      if ("normal".equals(paramString)) {
        i = 0;
      }
    }
  }
  
  @ReactProp(name="fontWeight")
  public void setFontWeight(@Nullable String paramString)
  {
    int j;
    int k;
    int i;
    if (paramString != null)
    {
      j = parseNumericFontWeight(paramString);
      k = -1;
      if ((j < 500) && (!"bold".equals(paramString))) {
        break label54;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != this.mFontWeight)
      {
        this.mFontWeight = i;
        markUpdated();
      }
      return;
      j = -1;
      break;
      label54:
      if (!"normal".equals(paramString))
      {
        i = k;
        if (j != -1)
        {
          i = k;
          if (j >= 500) {}
        }
      }
      else
      {
        i = 0;
      }
    }
  }
  
  @ReactProp(defaultInt=-1, name="lineHeight")
  public void setLineHeight(int paramInt)
  {
    this.mLineHeight = paramInt;
    markUpdated();
  }
  
  @ReactProp(defaultInt=-1, name="numberOfLines")
  public void setNumberOfLines(int paramInt)
  {
    this.mNumberOfLines = paramInt;
    markUpdated();
  }
  
  @ReactProp(name="text")
  public void setText(@Nullable String paramString)
  {
    this.mText = paramString;
    markUpdated();
  }
  
  private static class SetSpanOperation
  {
    protected int end;
    protected int start;
    protected Object what;
    
    SetSpanOperation(int paramInt1, int paramInt2, Object paramObject)
    {
      this.start = paramInt1;
      this.end = paramInt2;
      this.what = paramObject;
    }
    
    public void execute(SpannableStringBuilder paramSpannableStringBuilder)
    {
      int i = 34;
      if (this.start == 0) {
        i = 18;
      }
      paramSpannableStringBuilder.setSpan(this.what, this.start, this.end, i);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\text\ReactTextShadowNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */