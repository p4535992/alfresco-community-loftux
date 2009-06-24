<!--[if IE]>
<iframe id="yui-history-iframe" src="${url.context}/yui/assets/blank.html"></iframe>
<![endif]-->
<input id="yui-history-field" type="hidden" />

<script type="text/javascript">//<![CDATA[
   new Alfresco.ConsoleGroups("${args.htmlid}").setOptions({
      minSearchTermLength: "${args.minSearchTermLength!'1'}",
      maxSearchResults: "${args.maxSearchResults!'100'}"
   }).setMessages(
      ${messages}
   );
//]]></script>

<#assign el=args.htmlid>
<div id="${el}-body" class="groups">

   <!-- Search panel -->
   <div id="${el}-search">
      <div class="yui-g">
         <div class="yui-u first">
            <div class="title"><label for="${el}-search-text">${msg("label.title-browse")}</label></div>
         </div>
         <div class="yui-u align-right">
         </div>
      </div>
      <div class="yui-g separator">
         <div class="yui-u first">
            <div class="search-text">
               <input type="text" id="${el}-search-text" name="-" value="" />
               <!-- Search button -->
               <div class="search-button">
                  <span class="yui-button yui-push-button" id="${el}-search-button">
                     <span class="first-child"><button>${msg("button.search")}</button></span>
                  </span>
               </div>
            </div>
         </div>
         <div class="yui-u align-right">
            <!-- TODO: enabled/disabled account list filter? -->
         </div>
      </div>
      <div id="${el}-browse-panel" class="browse-main">
         <div id="${el}-breadcrumb" class="theme-bg-color-3"></div>
         <div id="${el}-columnbrowser"></div>
      </div>
      <div id="${el}-search-panel" class="search-main hidden">
         <div id="${el}-search-bar" class="search-bar theme-bg-color-3">
            <div id="${el}-search-bar-text" class="search-bar-text">${msg("message.noresults")}</div>
            <!-- Search button -->
            <div class="closesearch-button">
               <span class="yui-button yui-push-button" id="${el}-closesearch-button">
                  <span class="first-child"><button>${msg("button.close")}</button></span>
               </span>
            </div>
         </div>
         <div class="results" id="${el}-datatable"></div>
      </div>

      <!-- People Finder Dialog -->
      <div id="${el}-peoplepicker" class="groups people-picker hidden">
         <div class="hd"><span id="${el}-peoplepicker-title">${msg("panel.adduser.header")}</span></div>
         <div class="bd">
            <div>
               <div id="${el}-search-peoplefinder"></div>
            </div>
         </div>
      </div>

      <!-- Group Finder Dialog -->
      <div id="${el}-grouppicker" class="groups group-picker hidden">
         <div class="hd"><span id="${el}-grouppicker-title">${msg("panel.addgroup.header")}</span></div>
         <div class="bd">
            <div>
               <div id="${el}-search-groupfinder"></div>
            </div>
         </div>
      </div>

      <!-- Remove Group Dialog -->
      <div id="${el}-deletegroupdialog" class="groups remove-dialog hidden">
         <div class="hd">${msg("panel.deletegroup.header")}</div>
         <div class="bd">
            <div id="${el}-singleparent" class="dialog-panel">
               <div>
                  <span id="${el}-singleparent-message"></span>
               </div>
            </div>
            <div id="${el}-multiparent" class="dialog-panel hidden">
               <div>
                  <span id="${el}-multiparent-message"></span>
               </div>
               <div id="${el}-parents" class="parent-list"></div>
               <div id="${el}-removerow" class="yui-gf">
                  <div class="yui-u first">
                     <input id="${el}-remove" type="radio" checked="checked" name="-" />
                  </div>
                  <div class="yui-u">
                     <span id="${el}-remove-message"></span>
                  </div>
               </div>
               <div id="${el}-deleterow" class="yui-gf">
                  <div class="yui-u first">
                     <input id="${el}-delete" type="radio" name="-" />
                  </div>
                  <div class="yui-u">
                     <span id="${el}-delete-message"></span>
                     <div class="">${msg("panel.deletegroup.deletewarning")}</div>
                  </div>
               </div>
               <div id="${el}-searchdeleterow">
                  <span id="${el}-searchdelete-message"></span>
               </div>
            </div>
            <div class="bdft">
               <input type="submit" id="${el}-remove-button" value="${msg("button.remove")}"/>
               <input type="button" id="${el}-cancel-button" value="${msg("button.cancel")}"/>
            </div>
         </div>
      </div>

   </div>

   <!-- Create Group panel -->
   <div id="${el}-create" class="hidden">
      <div class="yui-g separator">
         <div class="yui-u first">
            <div class="title">${msg("label.title-create")}</div>
         </div>
         <div class="yui-u">
            <div style="float:right">* ${msg("label.requiredfield")}</div>
         </div>
      </div>

      <div id="${el}-create-main" class="create-main">
         <!-- Each info section separated by a header-bar div -->
         <div class="header-bar">${msg("label.properties")}</div>
         <div class="field-row">
            <span class="crud-label">${msg("label.shortname")}:&nbsp;*&nbsp;${msg("label.shortname.warning")}</span>
         </div>
         <div class="field-row">
            <input class="crud-input" id="${el}-create-shortname" type="text" maxlength="255" />
         </div>
         <div class="field-row">
            <span class="crud-label">${msg("label.displayname")}:&nbsp;*</span>
         </div>
         <div class="field-row">
            <input class="crud-input" id="${el}-create-displayname" type="text" maxlength="256" />
         </div>
      </div>

      <div>
         <div class="creategroup-ok-button left">
            <span class="yui-button yui-push-button" id="${el}-creategroup-ok-button">
               <span class="first-child"><button>${msg("button.creategroup")}</button></span>
            </span>
         </div>
         <div class="creategroup-another-button left">
            <span class="yui-button yui-push-button" id="${el}-creategroup-another-button">
               <span class="first-child"><button>${msg("button.createanother")}</button></span>
            </span>
         </div>
         <div class="creategroup-cancel-button">
            <span class="yui-button yui-push-button" id="${el}-creategroup-cancel-button">
               <span class="first-child"><button>${msg("button.cancel")}</button></span>
            </span>
         </div>
      </div>
   </div>
   

   <!-- Update Group panel -->
   <div id="${el}-update" class="hidden">
      <div class="yui-g separator">
         <div class="yui-u first">
            <div class="title">${msg("label.title-update")}: <span id="${el}-update-title"></span></div>
         </div>
         <div class="yui-u">
            <div style="float:right">* ${msg("label.requiredfield")}</div>
         </div>
      </div>

      <div id="${el}-update-main" class="update-main">
         <!-- Each info section separated by a header-bar div -->
         <div class="header-bar">${msg("label.properties")}</div>
         <div class="field-row">
            <span class="crud-label">${msg("label.shortname")}:&nbsp;*</span>
         </div>
         <div class="field-row">
            <span class="crud-input" id="${el}-update-shortname"></span>
         </div>
         <div class="field-row">
            <span class="crud-label">${msg("label.displayname")}:&nbsp;*</span>
         </div>
         <div class="field-row">
            <input class="crud-input" id="${el}-update-displayname" type="text" maxlength="256" />
         </div>
      </div>

      <div>
         <div class="updategroup-save-button left">
            <span class="yui-button yui-push-button" id="${el}-updategroup-save-button">
               <span class="first-child"><button>${msg("button.savechanges")}</button></span>
            </span>
         </div>
         <div class="updategroup-cancel-button">
            <span class="yui-button yui-push-button" id="${el}-updategroup-cancel-button">
               <span class="first-child"><button>${msg("button.cancel")}</button></span>
            </span>
         </div>
      </div>
   </div>

</div>