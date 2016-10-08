package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.MapBuilder;
import com.facebook.systrace.Systrace;
import com.fasterxml.jackson.core.JsonGenerator;
import com.tencent.bitapp.pre.binder.server.proxy.jni.ReadableNativeArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class NativeModuleRegistry
{
  private final ArrayList<OnBatchCompleteListener> mBatchCompleteListenerModules;
  private final Map<Class<? extends NativeModule>, NativeModule> mModuleInstances;
  private final List<ModuleDefinition> mModuleTable;
  
  private NativeModuleRegistry(List<ModuleDefinition> paramList, Map<Class<? extends NativeModule>, NativeModule> paramMap)
  {
    this.mModuleTable = paramList;
    this.mModuleInstances = paramMap;
    this.mBatchCompleteListenerModules = new ArrayList(this.mModuleTable.size());
    int i = 0;
    while (i < this.mModuleTable.size())
    {
      paramList = (ModuleDefinition)this.mModuleTable.get(i);
      if ((paramList.target instanceof OnBatchCompleteListener)) {
        this.mBatchCompleteListenerModules.add((OnBatchCompleteListener)paramList.target);
      }
      i += 1;
    }
  }
  
  void call(CatalystInstance paramCatalystInstance, int paramInt1, int paramInt2, ReadableNativeArray paramReadableNativeArray)
  {
    ModuleDefinition localModuleDefinition = (ModuleDefinition)this.mModuleTable.get(paramInt1);
    if (localModuleDefinition == null) {
      throw new RuntimeException("Call to unknown module: " + paramInt1);
    }
    localModuleDefinition.call(paramCatalystInstance, paramInt2, paramReadableNativeArray);
  }
  
  public Collection<NativeModule> getAllModules()
  {
    return this.mModuleInstances.values();
  }
  
  public <T extends NativeModule> T getModule(Class<T> paramClass)
  {
    return (NativeModule)Assertions.assertNotNull(this.mModuleInstances.get(paramClass));
  }
  
  void notifyCatalystInstanceDestroy()
  {
    UiThreadUtil.assertOnUiThread();
    Systrace.beginSection(0L, "NativeModuleRegistry_notifyCatalystInstanceDestroy");
    try
    {
      Iterator localIterator = this.mModuleInstances.values().iterator();
      while (localIterator.hasNext()) {
        ((NativeModule)localIterator.next()).onCatalystInstanceDestroy();
      }
    }
    finally
    {
      Systrace.endSection(0L);
    }
  }
  
  void notifyCatalystInstanceInitialized()
  {
    UiThreadUtil.assertOnUiThread();
    ReactMarker.logMarker("NativeModule_start");
    Systrace.beginSection(0L, "NativeModuleRegistry_notifyCatalystInstanceInitialized");
    try
    {
      Iterator localIterator = this.mModuleInstances.values().iterator();
      while (localIterator.hasNext()) {
        ((NativeModule)localIterator.next()).initialize();
      }
      Systrace.endSection(0L);
    }
    finally
    {
      Systrace.endSection(0L);
      ReactMarker.logMarker("NativeModule_end");
    }
    ReactMarker.logMarker("NativeModule_end");
  }
  
  public void onBatchComplete()
  {
    int i = 0;
    while (i < this.mBatchCompleteListenerModules.size())
    {
      ((OnBatchCompleteListener)this.mBatchCompleteListenerModules.get(i)).onBatchComplete();
      i += 1;
    }
  }
  
  void writeModuleDescriptions(JsonGenerator paramJsonGenerator)
    throws IOException
  {
    Systrace.beginSection(0L, "CreateJSON");
    try
    {
      paramJsonGenerator.writeStartObject();
      Iterator localIterator = this.mModuleTable.iterator();
      while (localIterator.hasNext())
      {
        ModuleDefinition localModuleDefinition = (ModuleDefinition)localIterator.next();
        paramJsonGenerator.writeObjectFieldStart(localModuleDefinition.name);
        paramJsonGenerator.writeNumberField("moduleID", localModuleDefinition.id);
        paramJsonGenerator.writeObjectFieldStart("methods");
        int i = 0;
        while (i < localModuleDefinition.methods.size())
        {
          MethodRegistration localMethodRegistration = (MethodRegistration)localModuleDefinition.methods.get(i);
          paramJsonGenerator.writeObjectFieldStart(localMethodRegistration.name);
          paramJsonGenerator.writeNumberField("methodID", i);
          paramJsonGenerator.writeStringField("type", localMethodRegistration.method.getType());
          paramJsonGenerator.writeEndObject();
          i += 1;
        }
        paramJsonGenerator.writeEndObject();
        localModuleDefinition.target.writeConstantsField(paramJsonGenerator, "constants");
        paramJsonGenerator.writeEndObject();
      }
      paramJsonGenerator.writeEndObject();
    }
    finally
    {
      Systrace.endSection(0L);
    }
    Systrace.endSection(0L);
  }
  
  public static class Builder
  {
    private final HashMap<String, NativeModule> mModules = MapBuilder.newHashMap();
    
    public Builder add(NativeModule paramNativeModule)
    {
      NativeModule localNativeModule = (NativeModule)this.mModules.get(paramNativeModule.getName());
      if ((localNativeModule != null) && (!paramNativeModule.canOverrideExistingModule())) {
        throw new IllegalStateException("Native module " + paramNativeModule.getClass().getSimpleName() + " tried to override " + localNativeModule.getClass().getSimpleName() + " for module name " + paramNativeModule.getName() + ". If this was your intention, return true from " + paramNativeModule.getClass().getSimpleName() + "#canOverrideExistingModule()");
      }
      this.mModules.put(paramNativeModule.getName(), paramNativeModule);
      return this;
    }
    
    public NativeModuleRegistry build()
    {
      ArrayList localArrayList = new ArrayList();
      HashMap localHashMap = new HashMap();
      int i = 0;
      Iterator localIterator = this.mModules.values().iterator();
      while (localIterator.hasNext())
      {
        NativeModule localNativeModule = (NativeModule)localIterator.next();
        localArrayList.add(new NativeModuleRegistry.ModuleDefinition(i, localNativeModule.getName(), localNativeModule));
        localHashMap.put(localNativeModule.getClass(), localNativeModule);
        i += 1;
      }
      return new NativeModuleRegistry(localArrayList, localHashMap, null);
    }
  }
  
  private static class MethodRegistration
  {
    public NativeModule.NativeMethod method;
    public String name;
    public String tracingName;
    
    public MethodRegistration(String paramString1, String paramString2, NativeModule.NativeMethod paramNativeMethod)
    {
      this.name = paramString1;
      this.tracingName = paramString2;
      this.method = paramNativeMethod;
    }
  }
  
  private static class ModuleDefinition
  {
    public final int id;
    public final ArrayList<NativeModuleRegistry.MethodRegistration> methods;
    public final String name;
    public final NativeModule target;
    
    public ModuleDefinition(int paramInt, String paramString, NativeModule paramNativeModule)
    {
      this.id = paramInt;
      this.name = paramString;
      this.target = paramNativeModule;
      this.methods = new ArrayList();
      paramString = paramNativeModule.getMethods().entrySet().iterator();
      while (paramString.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramString.next();
        this.methods.add(new NativeModuleRegistry.MethodRegistration((String)localEntry.getKey(), "NativeCall__" + paramNativeModule.getName() + "_" + (String)localEntry.getKey(), (NativeModule.NativeMethod)localEntry.getValue()));
      }
    }
    
    public void call(CatalystInstance paramCatalystInstance, int paramInt, ReadableNativeArray paramReadableNativeArray)
    {
      Systrace.beginSection(0L, ((NativeModuleRegistry.MethodRegistration)this.methods.get(paramInt)).tracingName);
      try
      {
        ((NativeModuleRegistry.MethodRegistration)this.methods.get(paramInt)).method.invoke(paramCatalystInstance, paramReadableNativeArray);
        return;
      }
      finally
      {
        Systrace.endSection(0L);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\bridge\NativeModuleRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */