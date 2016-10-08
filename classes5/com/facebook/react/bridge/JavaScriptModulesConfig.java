package com.facebook.react.bridge;

import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class JavaScriptModulesConfig
{
  private final List<JavaScriptModuleRegistration> mModules;
  
  private JavaScriptModulesConfig(List<JavaScriptModuleRegistration> paramList)
  {
    this.mModules = paramList;
  }
  
  private void appendJSModuleToJSONObject(JsonGenerator paramJsonGenerator, JavaScriptModuleRegistration paramJavaScriptModuleRegistration)
    throws IOException
  {
    paramJsonGenerator.writeObjectField("moduleID", Integer.valueOf(paramJavaScriptModuleRegistration.getModuleId()));
    paramJsonGenerator.writeObjectFieldStart("methods");
    Iterator localIterator = paramJavaScriptModuleRegistration.getMethods().iterator();
    while (localIterator.hasNext())
    {
      Method localMethod = (Method)localIterator.next();
      paramJsonGenerator.writeObjectFieldStart(localMethod.getName());
      paramJsonGenerator.writeObjectField("methodID", Integer.valueOf(paramJavaScriptModuleRegistration.getMethodId(localMethod)));
      paramJsonGenerator.writeEndObject();
    }
    paramJsonGenerator.writeEndObject();
  }
  
  List<JavaScriptModuleRegistration> getModuleDefinitions()
  {
    return this.mModules;
  }
  
  void writeModuleDescriptions(JsonGenerator paramJsonGenerator)
    throws IOException
  {
    paramJsonGenerator.writeStartObject();
    Iterator localIterator = this.mModules.iterator();
    while (localIterator.hasNext())
    {
      JavaScriptModuleRegistration localJavaScriptModuleRegistration = (JavaScriptModuleRegistration)localIterator.next();
      paramJsonGenerator.writeObjectFieldStart(localJavaScriptModuleRegistration.getName());
      appendJSModuleToJSONObject(paramJsonGenerator, localJavaScriptModuleRegistration);
      paramJsonGenerator.writeEndObject();
    }
    paramJsonGenerator.writeEndObject();
  }
  
  public static class Builder
  {
    private int mLastJSModuleId = 0;
    private List<JavaScriptModuleRegistration> mModules = new ArrayList();
    
    public Builder add(Class<? extends JavaScriptModule> paramClass)
    {
      int i = this.mLastJSModuleId;
      this.mLastJSModuleId = (i + 1);
      this.mModules.add(new JavaScriptModuleRegistration(i, paramClass));
      return this;
    }
    
    public JavaScriptModulesConfig build()
    {
      return new JavaScriptModulesConfig(this.mModules, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\JavaScriptModulesConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */