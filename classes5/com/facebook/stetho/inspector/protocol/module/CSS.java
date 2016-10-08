package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.common.ListUtil;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.Document;
import com.facebook.stetho.inspector.elements.Origin;
import com.facebook.stetho.inspector.elements.StyleAccumulator;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public class CSS
  implements ChromeDevtoolsDomain
{
  private final Document mDocument;
  private final ObjectMapper mObjectMapper;
  private final ChromePeerManager mPeerManager;
  
  public CSS(Document paramDocument)
  {
    this.mDocument = ((Document)Util.throwIfNull(paramDocument));
    this.mObjectMapper = new ObjectMapper();
    this.mPeerManager = new ChromePeerManager();
    this.mPeerManager.setListener(new PeerManagerListener(null));
  }
  
  @ChromeDevtoolsMethod
  public void disable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {}
  
  @ChromeDevtoolsMethod
  public void enable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {}
  
  @ChromeDevtoolsMethod
  public JsonRpcResult getComputedStyleForNode(final JsonRpcPeer paramJsonRpcPeer, final JSONObject paramJSONObject)
  {
    paramJsonRpcPeer = (GetComputedStyleForNodeRequest)this.mObjectMapper.convertValue(paramJSONObject, GetComputedStyleForNodeRequest.class);
    paramJSONObject = new GetComputedStyleForNodeResult(null);
    paramJSONObject.computedStyle = new ArrayList();
    this.mDocument.postAndWait(new Runnable()
    {
      public void run()
      {
        Object localObject = CSS.this.mDocument.getElementForNodeId(paramJsonRpcPeer.nodeId);
        if (localObject == null)
        {
          LogUtil.e("Tried to get the style of an element that does not exist, using nodeid=" + paramJsonRpcPeer.nodeId);
          return;
        }
        CSS.this.mDocument.getElementStyles(localObject, new StyleAccumulator()
        {
          public void store(String paramAnonymous2String1, String paramAnonymous2String2, boolean paramAnonymous2Boolean)
          {
            if (!paramAnonymous2Boolean)
            {
              CSS.CSSComputedStyleProperty localCSSComputedStyleProperty = new CSS.CSSComputedStyleProperty(null);
              localCSSComputedStyleProperty.name = paramAnonymous2String1;
              localCSSComputedStyleProperty.value = paramAnonymous2String2;
              this.val$result.computedStyle.add(localCSSComputedStyleProperty);
            }
          }
        });
      }
    });
    return paramJSONObject;
  }
  
  @ChromeDevtoolsMethod
  public JsonRpcResult getMatchedStylesForNode(final JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
  {
    paramJsonRpcPeer = (GetMatchedStylesForNodeRequest)this.mObjectMapper.convertValue(paramJSONObject, GetMatchedStylesForNodeRequest.class);
    paramJSONObject = new GetMatchedStylesForNodeResult(null);
    final RuleMatch localRuleMatch = new RuleMatch(null);
    paramJSONObject.matchedCSSRules = ListUtil.newImmutableList(localRuleMatch);
    localRuleMatch.matchingSelectors = ListUtil.newImmutableList(Integer.valueOf(0));
    Selector localSelector = new Selector(null);
    localSelector.value = "<this_element>";
    CSSRule localCSSRule = new CSSRule(null);
    localCSSRule.origin = Origin.REGULAR;
    localCSSRule.selectorList = new SelectorList(null);
    localCSSRule.selectorList.selectors = ListUtil.newImmutableList(localSelector);
    localCSSRule.style = new CSSStyle(null);
    localCSSRule.style.cssProperties = new ArrayList();
    localRuleMatch.rule = localCSSRule;
    localCSSRule.style.shorthandEntries = Collections.emptyList();
    this.mDocument.postAndWait(new Runnable()
    {
      public void run()
      {
        Object localObject = CSS.this.mDocument.getElementForNodeId(paramJsonRpcPeer.nodeId);
        if (localObject == null)
        {
          LogUtil.w("Failed to get style of an element that does not exist, nodeid=" + paramJsonRpcPeer.nodeId);
          return;
        }
        CSS.this.mDocument.getElementStyles(localObject, new StyleAccumulator()
        {
          public void store(String paramAnonymous2String1, String paramAnonymous2String2, boolean paramAnonymous2Boolean)
          {
            if (!paramAnonymous2Boolean)
            {
              CSS.CSSProperty localCSSProperty = new CSS.CSSProperty(null);
              localCSSProperty.name = paramAnonymous2String1;
              localCSSProperty.value = paramAnonymous2String2;
              this.val$match.rule.style.cssProperties.add(localCSSProperty);
            }
          }
        });
      }
    });
    paramJSONObject.inherited = Collections.emptyList();
    paramJSONObject.pseudoElements = Collections.emptyList();
    return paramJSONObject;
  }
  
  private static class CSSComputedStyleProperty
  {
    @JsonProperty(required=true)
    public String name;
    @JsonProperty(required=true)
    public String value;
  }
  
  private static class CSSProperty
  {
    @JsonProperty
    public Boolean disabled;
    @JsonProperty
    public Boolean implicit;
    @JsonProperty
    public Boolean important;
    @JsonProperty(required=true)
    public String name;
    @JsonProperty
    public Boolean parsedOk;
    @JsonProperty
    public CSS.SourceRange range;
    @JsonProperty
    public String text;
    @JsonProperty(required=true)
    public String value;
  }
  
  private static class CSSRule
  {
    @JsonProperty
    public Origin origin;
    @JsonProperty(required=true)
    public CSS.SelectorList selectorList;
    @JsonProperty
    public CSS.CSSStyle style;
    @JsonProperty
    public String styleSheetId;
  }
  
  private static class CSSStyle
  {
    @JsonProperty(required=true)
    public List<CSS.CSSProperty> cssProperties;
    @JsonProperty
    public String cssText;
    @JsonProperty
    public CSS.SourceRange range;
    @JsonProperty
    public List<CSS.ShorthandEntry> shorthandEntries;
    @JsonProperty
    public String styleSheetId;
  }
  
  private static class GetComputedStyleForNodeRequest
  {
    @JsonProperty(required=true)
    public int nodeId;
  }
  
  private static class GetComputedStyleForNodeResult
    implements JsonRpcResult
  {
    @JsonProperty(required=true)
    public List<CSS.CSSComputedStyleProperty> computedStyle;
  }
  
  private static class GetMatchedStylesForNodeRequest
    implements JsonRpcResult
  {
    @JsonProperty
    public Boolean excludeInherited;
    @JsonProperty
    public Boolean excludePseudo;
    @JsonProperty(required=true)
    public int nodeId;
  }
  
  private static class GetMatchedStylesForNodeResult
    implements JsonRpcResult
  {
    @JsonProperty
    public List<CSS.InheritedStyleEntry> inherited;
    @JsonProperty
    public List<CSS.RuleMatch> matchedCSSRules;
    @JsonProperty
    public List<CSS.PseudoIdMatches> pseudoElements;
  }
  
  private static class InheritedStyleEntry
  {
    @JsonProperty(required=true)
    public CSS.CSSStyle inlineStyle;
    @JsonProperty(required=true)
    public List<CSS.RuleMatch> matchedCSSRules;
  }
  
  private final class PeerManagerListener
    extends PeersRegisteredListener
  {
    private PeerManagerListener() {}
    
    protected void onFirstPeerRegistered()
    {
      try
      {
        CSS.this.mDocument.addRef();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    protected void onLastPeerUnregistered()
    {
      try
      {
        CSS.this.mDocument.release();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
  
  private static class PseudoIdMatches
  {
    @JsonProperty(required=true)
    public List<CSS.RuleMatch> matches = new ArrayList();
    @JsonProperty(required=true)
    public int pseudoId;
  }
  
  private static class RuleMatch
  {
    @JsonProperty
    public List<Integer> matchingSelectors;
    @JsonProperty
    public CSS.CSSRule rule;
  }
  
  private static class Selector
  {
    @JsonProperty
    public CSS.SourceRange range;
    @JsonProperty(required=true)
    public String value;
  }
  
  private static class SelectorList
  {
    @JsonProperty
    public List<CSS.Selector> selectors;
    @JsonProperty
    public String text;
  }
  
  private static class ShorthandEntry
  {
    @JsonProperty
    public Boolean imporant;
    @JsonProperty(required=true)
    public String name;
    @JsonProperty(required=true)
    public String value;
  }
  
  private static class SourceRange
  {
    @JsonProperty(required=true)
    public int endColumn;
    @JsonProperty(required=true)
    public int endLine;
    @JsonProperty(required=true)
    public int startColumn;
    @JsonProperty(required=true)
    public int startLine;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\protocol\module\CSS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */