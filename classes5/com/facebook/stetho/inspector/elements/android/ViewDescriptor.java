package com.facebook.stetho.inspector.elements.android;

import android.view.View;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewDebug.FlagToString;
import android.view.ViewDebug.IntToString;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.StringUtil;
import com.facebook.stetho.common.android.ResourcesUtil;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.AttributeAccumulator;
import com.facebook.stetho.inspector.elements.StyleAccumulator;
import com.facebook.stetho.inspector.helper.IntegerFormatter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class ViewDescriptor
  extends AbstractChainedDescriptor<View>
  implements HighlightableDescriptor
{
  private static final String ID_NAME = "id";
  private static final String NONE_MAPPING = "<no mapping>";
  private static final String NONE_VALUE = "(none)";
  private final MethodInvoker mMethodInvoker;
  @Nullable
  @GuardedBy("this")
  private volatile List<ViewCSSProperty> mViewProperties;
  @Nullable
  private Pattern mWordBoundaryPattern;
  
  public ViewDescriptor()
  {
    this(new MethodInvoker());
  }
  
  public ViewDescriptor(MethodInvoker paramMethodInvoker)
  {
    this.mMethodInvoker = paramMethodInvoker;
  }
  
  private static boolean canFlagsBeMappedToString(@Nullable ViewDebug.ExportedProperty paramExportedProperty)
  {
    return (paramExportedProperty != null) && (paramExportedProperty.flagMapping() != null) && (paramExportedProperty.flagMapping().length > 0);
  }
  
  private static boolean canIntBeMappedToString(@Nullable ViewDebug.ExportedProperty paramExportedProperty)
  {
    return (paramExportedProperty != null) && (paramExportedProperty.mapping() != null) && (paramExportedProperty.mapping().length > 0);
  }
  
  private static String capitalize(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || (Character.isTitleCase(paramString.charAt(0)))) {
      return paramString;
    }
    paramString = new StringBuilder(paramString);
    paramString.setCharAt(0, Character.toTitleCase(paramString.charAt(0)));
    return paramString.toString();
  }
  
  private String convertViewPropertyNameToCSSName(String paramString)
  {
    paramString = getWordBoundaryPattern().split(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i >= paramString.length) {
      return localStringBuilder.toString();
    }
    if ((paramString[i].equals("get")) || (paramString[i].equals("m"))) {}
    for (;;)
    {
      i += 1;
      break;
      localStringBuilder.append(paramString[i].toLowerCase());
      if (i < paramString.length - 1) {
        localStringBuilder.append('-');
      }
    }
  }
  
  @Nullable
  private static String getIdAttribute(View paramView)
  {
    int i = paramView.getId();
    if (i == -1) {
      return null;
    }
    return ResourcesUtil.getIdStringQuietly(paramView, paramView.getResources(), i);
  }
  
  private void getIdStyle(View paramView, StyleAccumulator paramStyleAccumulator)
  {
    paramView = getIdAttribute(paramView);
    if (paramView == null)
    {
      paramStyleAccumulator.store("id", "(none)", false);
      return;
    }
    paramStyleAccumulator.store("id", paramView, false);
  }
  
  private void getStyleFromFloat(String paramString, Float paramFloat, @Nullable ViewDebug.ExportedProperty paramExportedProperty, StyleAccumulator paramStyleAccumulator)
  {
    paramStyleAccumulator.store(paramString, String.valueOf(paramFloat), isDefaultValue(paramFloat));
  }
  
  private void getStyleFromInteger(String paramString, Integer paramInteger, @Nullable ViewDebug.ExportedProperty paramExportedProperty, StyleAccumulator paramStyleAccumulator)
  {
    String str = IntegerFormatter.getInstance().format(paramInteger, paramExportedProperty);
    if (canIntBeMappedToString(paramExportedProperty))
    {
      paramStyleAccumulator.store(paramString, str + " (" + mapIntToStringUsingAnnotation(paramInteger.intValue(), paramExportedProperty) + ")", false);
      return;
    }
    if (canFlagsBeMappedToString(paramExportedProperty))
    {
      paramStyleAccumulator.store(paramString, str + " (" + mapFlagsToStringUsingAnnotation(paramInteger.intValue(), paramExportedProperty) + ")", false);
      return;
    }
    paramStyleAccumulator.store(paramString, str, isDefaultValue(paramInteger, paramExportedProperty));
  }
  
  private void getStyleFromValue(View paramView, String paramString, Object paramObject, @Nullable ViewDebug.ExportedProperty paramExportedProperty, StyleAccumulator paramStyleAccumulator)
  {
    if (paramString.equals("id"))
    {
      getIdStyle(paramView, paramStyleAccumulator);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      getStyleFromInteger(paramString, (Integer)paramObject, paramExportedProperty, paramStyleAccumulator);
      return;
    }
    if ((paramObject instanceof Float))
    {
      getStyleFromFloat(paramString, (Float)paramObject, paramExportedProperty, paramStyleAccumulator);
      return;
    }
    getStylesFromObject(paramView, paramString, paramObject, paramExportedProperty, paramStyleAccumulator);
  }
  
  private void getStylesFromObject(View paramView, String paramString, Object paramObject, @Nullable ViewDebug.ExportedProperty paramExportedProperty, StyleAccumulator paramStyleAccumulator)
  {
    if ((paramExportedProperty == null) || (!paramExportedProperty.deepExport()) || (paramObject == null)) {}
    Field[] arrayOfField;
    int j;
    int i;
    do
    {
      return;
      arrayOfField = paramObject.getClass().getFields();
      j = arrayOfField.length;
      i = 0;
    } while (i >= j);
    Field localField = arrayOfField[i];
    String str1;
    for (;;)
    {
      try
      {
        localField.setAccessible(true);
        Object localObject = localField.get(paramObject);
        str1 = localField.getName();
        if ("bottomMargin".equals(str1))
        {
          str1 = "margin-bottom";
          getStyleFromValue(paramView, str1, localObject, (ViewDebug.ExportedProperty)localField.getAnnotation(ViewDebug.ExportedProperty.class), paramStyleAccumulator);
          i += 1;
        }
      }
      catch (IllegalAccessException paramView)
      {
        LogUtil.e(paramView, "failed to get property of name: \"" + paramString + "\" of object: " + String.valueOf(paramObject));
        return;
      }
      if ("topMargin".equals(str1))
      {
        str1 = "margin-top";
      }
      else if ("leftMargin".equals(str1))
      {
        str1 = "margin-left";
      }
      else
      {
        if (!"rightMargin".equals(str1)) {
          break label209;
        }
        str1 = "margin-right";
      }
    }
    label209:
    String str2 = paramExportedProperty.prefix();
    if (str2 == null) {}
    for (;;)
    {
      str1 = convertViewPropertyNameToCSSName(str1);
      break;
      str1 = str2 + str1;
    }
  }
  
  private List<ViewCSSProperty> getViewProperties()
  {
    int j = 0;
    if (this.mViewProperties == null) {}
    for (;;)
    {
      int i;
      try
      {
        ArrayList localArrayList;
        Object localObject2;
        if (this.mViewProperties == null)
        {
          localArrayList = new ArrayList();
          localObject2 = View.class.getDeclaredMethods();
          int k = localObject2.length;
          i = 0;
          if (i >= k)
          {
            localObject2 = View.class.getDeclaredFields();
            k = localObject2.length;
            i = j;
            if (i < k) {
              continue;
            }
            Collections.sort(localArrayList, new Comparator()
            {
              public int compare(ViewDescriptor.ViewCSSProperty paramAnonymousViewCSSProperty1, ViewDescriptor.ViewCSSProperty paramAnonymousViewCSSProperty2)
              {
                return paramAnonymousViewCSSProperty1.getCSSName().compareTo(paramAnonymousViewCSSProperty2.getCSSName());
              }
            });
            this.mViewProperties = Collections.unmodifiableList(localArrayList);
          }
        }
        else
        {
          return this.mViewProperties;
        }
        Method localMethod = localObject2[i];
        ViewDebug.ExportedProperty localExportedProperty = (ViewDebug.ExportedProperty)localMethod.getAnnotation(ViewDebug.ExportedProperty.class);
        if (localExportedProperty != null)
        {
          localArrayList.add(new MethodBackedCSSProperty(localMethod, convertViewPropertyNameToCSSName(localMethod.getName()), localExportedProperty));
          break label200;
          localMethod = localObject2[i];
          localExportedProperty = (ViewDebug.ExportedProperty)localMethod.getAnnotation(ViewDebug.ExportedProperty.class);
          if (localExportedProperty == null) {
            break label209;
          }
          localArrayList.add(new FieldBackedCSSProperty(localMethod, convertViewPropertyNameToCSSName(localMethod.getName()), localExportedProperty));
        }
      }
      finally {}
      label200:
      i += 1;
      continue;
      label209:
      i += 1;
    }
  }
  
  private Pattern getWordBoundaryPattern()
  {
    if (this.mWordBoundaryPattern == null) {
      this.mWordBoundaryPattern = Pattern.compile("(?<=\\p{Lower})(?=\\p{Upper})");
    }
    return this.mWordBoundaryPattern;
  }
  
  private static boolean isDefaultValue(Float paramFloat)
  {
    return paramFloat.floatValue() == 0.0F;
  }
  
  private static boolean isDefaultValue(Integer paramInteger, @Nullable ViewDebug.ExportedProperty paramExportedProperty)
  {
    if ((canFlagsBeMappedToString(paramExportedProperty)) || (canIntBeMappedToString(paramExportedProperty))) {}
    while (paramInteger.intValue() != 0) {
      return false;
    }
    return true;
  }
  
  private static String mapFlagsToStringUsingAnnotation(int paramInt, @Nullable ViewDebug.ExportedProperty paramExportedProperty)
  {
    if (!canFlagsBeMappedToString(paramExportedProperty)) {
      throw new IllegalStateException("Cannot map using this annotation");
    }
    Object localObject = null;
    int j = 0;
    ViewDebug.FlagToString[] arrayOfFlagToString = paramExportedProperty.flagMapping();
    int m = arrayOfFlagToString.length;
    int i = 0;
    paramExportedProperty = (ViewDebug.ExportedProperty)localObject;
    if (i >= m)
    {
      if (j != 0) {
        return paramExportedProperty.toString();
      }
    }
    else
    {
      ViewDebug.FlagToString localFlagToString = arrayOfFlagToString[i];
      boolean bool2 = localFlagToString.outputIf();
      if ((localFlagToString.mask() & paramInt) == localFlagToString.equals()) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        int k = j;
        localObject = paramExportedProperty;
        if (bool2 == bool1)
        {
          localObject = paramExportedProperty;
          if (paramExportedProperty == null) {
            localObject = new StringBuilder();
          }
          if (j != 0) {
            ((StringBuilder)localObject).append(" | ");
          }
          ((StringBuilder)localObject).append(localFlagToString.name());
          k = 1;
        }
        i += 1;
        j = k;
        paramExportedProperty = (ViewDebug.ExportedProperty)localObject;
        break;
      }
    }
    return "<no mapping>";
  }
  
  private static String mapIntToStringUsingAnnotation(int paramInt, @Nullable ViewDebug.ExportedProperty paramExportedProperty)
  {
    if (!canIntBeMappedToString(paramExportedProperty)) {
      throw new IllegalStateException("Cannot map using this annotation");
    }
    paramExportedProperty = paramExportedProperty.mapping();
    int j = paramExportedProperty.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return "<no mapping>";
      }
      Object localObject = paramExportedProperty[i];
      if (((ViewDebug.IntToString)localObject).from() == paramInt) {
        return ((ViewDebug.IntToString)localObject).to();
      }
      i += 1;
    }
  }
  
  public View getViewForHighlighting(Object paramObject)
  {
    return (View)paramObject;
  }
  
  protected void onGetAttributes(View paramView, AttributeAccumulator paramAttributeAccumulator)
  {
    paramView = getIdAttribute(paramView);
    if (paramView != null) {
      paramAttributeAccumulator.store("id", paramView);
    }
  }
  
  protected String onGetNodeName(View paramView)
  {
    paramView = paramView.getClass().getName();
    return StringUtil.removePrefix(paramView, "android.view.", StringUtil.removePrefix(paramView, "android.widget."));
  }
  
  protected void onGetStyles(View paramView, StyleAccumulator paramStyleAccumulator)
  {
    List localList = getViewProperties();
    int i = 0;
    int j = localList.size();
    for (;;)
    {
      if (i >= j) {
        return;
      }
      ViewCSSProperty localViewCSSProperty = (ViewCSSProperty)localList.get(i);
      try
      {
        getStyleFromValue(paramView, localViewCSSProperty.getCSSName(), localViewCSSProperty.getValue(paramView), localViewCSSProperty.getAnnotation(), paramStyleAccumulator);
        i += 1;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          LogUtil.e(localIllegalAccessException, "failed to get style property " + localViewCSSProperty.getCSSName() + " of element= " + paramView.toString());
        }
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        for (;;)
        {
          LogUtil.e(localInvocationTargetException, "failed to get style property " + localViewCSSProperty.getCSSName() + " of element= " + paramView.toString());
        }
      }
    }
  }
  
  protected void onSetAttributesAsText(View paramView, String paramString)
  {
    paramString = parseSetAttributesAsTextArg(paramString).entrySet().iterator();
    for (;;)
    {
      if (!paramString.hasNext()) {
        return;
      }
      Object localObject = (Map.Entry)paramString.next();
      String str = "set" + capitalize((String)((Map.Entry)localObject).getKey());
      localObject = (String)((Map.Entry)localObject).getValue();
      this.mMethodInvoker.invoke(paramView, str, (String)localObject);
    }
  }
  
  private final class FieldBackedCSSProperty
    extends ViewDescriptor.ViewCSSProperty
  {
    private final Field mField;
    
    public FieldBackedCSSProperty(Field paramField, @Nullable String paramString, ViewDebug.ExportedProperty paramExportedProperty)
    {
      super(paramString, paramExportedProperty);
      this.mField = paramField;
      this.mField.setAccessible(true);
    }
    
    public Object getValue(View paramView)
      throws InvocationTargetException, IllegalAccessException
    {
      return this.mField.get(paramView);
    }
  }
  
  private final class MethodBackedCSSProperty
    extends ViewDescriptor.ViewCSSProperty
  {
    private final Method mMethod;
    
    public MethodBackedCSSProperty(Method paramMethod, @Nullable String paramString, ViewDebug.ExportedProperty paramExportedProperty)
    {
      super(paramString, paramExportedProperty);
      this.mMethod = paramMethod;
      this.mMethod.setAccessible(true);
    }
    
    public Object getValue(View paramView)
      throws InvocationTargetException, IllegalAccessException
    {
      return this.mMethod.invoke(paramView, new Object[0]);
    }
  }
  
  private abstract class ViewCSSProperty
  {
    private final ViewDebug.ExportedProperty mAnnotation;
    private final String mCSSName;
    
    public ViewCSSProperty(@Nullable String paramString, ViewDebug.ExportedProperty paramExportedProperty)
    {
      this.mCSSName = paramString;
      this.mAnnotation = paramExportedProperty;
    }
    
    @Nullable
    public final ViewDebug.ExportedProperty getAnnotation()
    {
      return this.mAnnotation;
    }
    
    public final String getCSSName()
    {
      return this.mCSSName;
    }
    
    public abstract Object getValue(View paramView)
      throws InvocationTargetException, IllegalAccessException;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\elements\android\ViewDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */