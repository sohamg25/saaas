function isCompatible(ua){if(ua===undefined){ua=navigator.userAgent;}return!((ua.indexOf('MSIE')!==-1&&parseFloat(ua.split('MSIE')[1])<6)||(ua.indexOf('Firefox/')!==-1&&parseFloat(ua.split('Firefox/')[1])<3)||ua.match(/BlackBerry[^\/]*\/[1-5]\./)||ua.match(/webOS\/1\.[0-4]/)||ua.match(/PlayStation/i)||ua.match(/SymbianOS|Series60/)||ua.match(/NetFront/)||ua.match(/Opera Mini/)||ua.match(/S40OviBrowser/));}var startUp=function(){mw.config=new mw.Map(true);mw.loader.addSource({"local":{"loadScript":"//bits.wikimedia.org/en.wikibooks.org/load.php","apiScript":"/w/api.php"}});(function(name,version,dependencies,group,source){})("MediaWikiSupport.loader","20131210T194337Z",[],null,"local");(function(name,version,dependencies,group,source){(function(mw,$){$(function(event){var $selected=$(mw.config.get('EmbedPlayer.RewriteSelector'));if($selected.length){var inx=0;var checkSetDone=function(){if(inx<$selected.length){$selected.slice(inx,inx+1).embedPlayer(function(){setTimeout(function(){
checkSetDone();},5);});}inx++;};checkSetDone();}});$.fn.embedPlayer=function(readyCallback){var playerSet=this;mw.log('jQuery.fn.embedPlayer :: '+$(this).length);var dependencySet=['mw.EmbedPlayer'];var rewriteElementCount=0;$(this).each(function(inx,playerElement){var skinName='';$(playerElement).removeAttr('controls');if(!$.browser.mozilla){$(playerElement).parent().getAbsoluteOverlaySpinner().attr('id','loadingSpinner_'+$(playerElement).attr('id'));}$(mw).trigger('EmbedPlayerUpdateDependencies',[playerElement,dependencySet]);});dependencySet=$.uniqueArray(dependencySet);mediaWiki.loader.using(dependencySet,function(){window.gM=mw.jqueryMsg.getMessageFunction({});mw.processEmbedPlayers(playerSet,readyCallback);},function(e){throw new Error('Error loading EmbedPlayer dependency set: '+e.message);});};})(window.mediaWiki,window.jQuery);})("EmbedPlayer.loader","20131210T194337Z",[],null,"local");(function(name,version,dependencies,group,source){(function(mw,$){$(mw).bind(
'EmbedPlayerUpdateDependencies',function(event,playerElement,classRequest){if(mw.isTimedTextSupported(playerElement)){classRequest=$.merge(classRequest,['mw.TimedText']);}});$(mw).bind('EmbedPlayerNewPlayer',function(event,embedPlayer){if(mw.isTimedTextSupported(embedPlayer)){embedPlayer.timedText=new mw.TimedText(embedPlayer);}});mw.isTimedTextSupported=function(embedPlayer){var mwprovider=embedPlayer['data-mwprovider']||$(embedPlayer).data('mwprovider');var showInterface=mw.config.get('TimedText.ShowInterface.'+mwprovider)||mw.config.get('TimedText.ShowInterface');if(showInterface=='always'){return true;}else if(showInterface=='off'){return false;}if($(embedPlayer).find('track').length!=0){return true;}else{return false;}};})(window.mediaWiki,window.jQuery);})("TimedText.loader","20131210T194337Z",[],null,"local");(function(name,version,dependencies,group,source){(function(mw,$){$(mw).bind('EmbedPlayerUpdateDependencies',function(event,embedPlayer,dependencySet){if($(embedPlayer).
attr('data-mwtitle')){$.merge(dependencySet,['mw.MediaWikiPlayerSupport']);}});})(window.mediaWiki,jQuery);})("mw.MediaWikiPlayer.loader","20131210T194337Z",[],null,"local");mw.loader.register([["site","1386704616",[],"site"],["noscript","1386704616",[],"noscript"],["startup","1387049325",[],"startup"],["filepage","1386704616"],["user.groups","1386704616",[],"user"],["user","1386704616",[],"user"],["user.cssprefs","1347062400",["mediawiki.user"],"private"],["user.options","1347062400",[],"private"],["user.tokens","1347062400",[],"private"],["mediawiki.language.data","1386119457",["mediawiki.language.init"]],["skins.cologneblue","1386704616"],["skins.modern","1386704616"],["skins.monobook","1386704616"],["skins.vector","1386704557"],["skins.vector.beta","1386704616"],["skins.vector.js","1386704576",["jquery.delayedBind"]],["skins.vector.collapsibleNav","1386902583",["jquery.client","jquery.cookie","jquery.tabIndex"]],["jquery","1386704609"],["jquery.appear","1386704616"],[
"jquery.arrowSteps","1386704616"],["jquery.async","1386704599"],["jquery.autoEllipsis","1386704616",["jquery.highlightText"]],["jquery.badge","1386704616",["mediawiki.language"]],["jquery.byteLength","1386704616"],["jquery.byteLimit","1386704616",["jquery.byteLength"]],["jquery.checkboxShiftClick","1386704616"],["jquery.chosen","1386704616"],["jquery.client","1386704575"],["jquery.color","1386704616",["jquery.colorUtil"]],["jquery.colorUtil","1386704616"],["jquery.cookie","1386704575"],["jquery.delayedBind","1386704575"],["jquery.expandableField","1386704616",["jquery.delayedBind"]],["jquery.farbtastic","1386704616",["jquery.colorUtil"]],["jquery.footHovzer","1386704616"],["jquery.form","1386704599"],["jquery.getAttrs","1386704616"],["jquery.hidpi","1386704616"],["jquery.highlightText","1386704616",["jquery.mwExtension"]],["jquery.hoverIntent","1386704616"],["jquery.json","1386704575"],["jquery.localize","1386704616"],["jquery.makeCollapsible","1386902583"],["jquery.mockjax",
"1386704616"],["jquery.mw-jump","1386704616"],["jquery.mwExtension","1386704576"],["jquery.placeholder","1386704616"],["jquery.qunit","1386704616"],["jquery.qunit.completenessTest","1386704616",["jquery.qunit"]],["jquery.spinner","1386704599"],["jquery.jStorage","1386704575",["jquery.json"]],["jquery.suggestions","1386704616",["jquery.autoEllipsis"]],["jquery.tabIndex","1386704616"],["jquery.tablesorter","1386902583",["jquery.mwExtension","mediawiki.language.months"]],["jquery.textSelection","1386704616",["jquery.client"]],["jquery.validate","1386704616"],["jquery.xmldom","1386704616"],["jquery.tipsy","1386704576"],["jquery.ui.core","1386704616",["jquery"],"jquery.ui"],["jquery.ui.widget","1386704616",[],"jquery.ui"],["jquery.ui.mouse","1386704616",["jquery.ui.widget"],"jquery.ui"],["jquery.ui.position","1386704616",[],"jquery.ui"],["jquery.ui.draggable","1386704616",["jquery.ui.core","jquery.ui.mouse","jquery.ui.widget"],"jquery.ui"],["jquery.ui.droppable","1386704616",[
"jquery.ui.core","jquery.ui.draggable","jquery.ui.mouse","jquery.ui.widget"],"jquery.ui"],["jquery.ui.resizable","1386704616",["jquery.ui.core","jquery.ui.mouse","jquery.ui.widget"],"jquery.ui"],["jquery.ui.selectable","1386704616",["jquery.ui.core","jquery.ui.mouse","jquery.ui.widget"],"jquery.ui"],["jquery.ui.sortable","1386704616",["jquery.ui.core","jquery.ui.mouse","jquery.ui.widget"],"jquery.ui"],["jquery.ui.accordion","1386704616",["jquery.ui.core","jquery.ui.widget"],"jquery.ui"],["jquery.ui.autocomplete","1386704616",["jquery.ui.core","jquery.ui.position","jquery.ui.widget"],"jquery.ui"],["jquery.ui.button","1386704616",["jquery.ui.core","jquery.ui.widget"],"jquery.ui"],["jquery.ui.datepicker","1386704616",["jquery.ui.core"],"jquery.ui"],["jquery.ui.dialog","1386704617",["jquery.ui.button","jquery.ui.core","jquery.ui.draggable","jquery.ui.mouse","jquery.ui.position","jquery.ui.resizable","jquery.ui.widget"],"jquery.ui"],["jquery.ui.progressbar","1386704617",["jquery.ui.core",
"jquery.ui.widget"],"jquery.ui"],["jquery.ui.slider","1386704617",["jquery.ui.core","jquery.ui.mouse","jquery.ui.widget"],"jquery.ui"],["jquery.ui.tabs","1386704617",["jquery.ui.core","jquery.ui.widget"],"jquery.ui"],["jquery.effects.core","1386704617",["jquery"],"jquery.ui"],["jquery.effects.blind","1386704617",["jquery.effects.core"],"jquery.ui"],["jquery.effects.bounce","1386704617",["jquery.effects.core"],"jquery.ui"],["jquery.effects.clip","1386704617",["jquery.effects.core"],"jquery.ui"],["jquery.effects.drop","1386704617",["jquery.effects.core"],"jquery.ui"],["jquery.effects.explode","1386704617",["jquery.effects.core"],"jquery.ui"],["jquery.effects.fade","1386704617",["jquery.effects.core"],"jquery.ui"],["jquery.effects.fold","1386704617",["jquery.effects.core"],"jquery.ui"],["jquery.effects.highlight","1386704617",["jquery.effects.core"],"jquery.ui"],["jquery.effects.pulsate","1386704617",["jquery.effects.core"],"jquery.ui"],["jquery.effects.scale","1386704617",[
"jquery.effects.core"],"jquery.ui"],["jquery.effects.shake","1386704617",["jquery.effects.core"],"jquery.ui"],["jquery.effects.slide","1386704617",["jquery.effects.core"],"jquery.ui"],["jquery.effects.transfer","1386704617",["jquery.effects.core"],"jquery.ui"],["mediawiki","1386704609"],["mediawiki.api","1386704576",["mediawiki.util"]],["mediawiki.api.category","1386704617",["mediawiki.Title","mediawiki.api"]],["mediawiki.api.edit","1386704617",["mediawiki.Title","mediawiki.api"]],["mediawiki.api.login","1386704617",["mediawiki.api"]],["mediawiki.api.parse","1386704617",["mediawiki.api"]],["mediawiki.api.watch","1386704599",["mediawiki.api","user.tokens"]],["mediawiki.debug","1386704617",["jquery.footHovzer"]],["mediawiki.debug.init","1386704617",["mediawiki.debug"]],["mediawiki.feedback","1386704617",["jquery.ui.dialog","mediawiki.Title","mediawiki.api.edit","mediawiki.jqueryMsg"]],["mediawiki.hidpi","1386704617",["jquery.hidpi"]],["mediawiki.hlist","1386704617",["jquery.client"]],[
"mediawiki.htmlform","1386902583"],["mediawiki.icon","1386704599"],["mediawiki.inspect","1386704617",["jquery.byteLength","jquery.json"]],["mediawiki.notification","1386704617",["mediawiki.page.startup"]],["mediawiki.notify","1386704576"],["mediawiki.searchSuggest","1386902583",["jquery.autoEllipsis","jquery.client","jquery.placeholder","jquery.suggestions","mediawiki.api"]],["mediawiki.Title","1386704617",["jquery.byteLength","mediawiki.util"]],["mediawiki.Uri","1386704576"],["mediawiki.user","1386704576",["jquery.cookie","mediawiki.api","user.options","user.tokens"]],["mediawiki.util","1386902583",["jquery.client","jquery.cookie","jquery.mwExtension","mediawiki.notify"]],["mediawiki.action.edit","1386704617",["jquery.byteLimit","jquery.textSelection","mediawiki.action.edit.styles"]],["mediawiki.action.edit.styles","1386704597"],["mediawiki.action.edit.collapsibleFooter","1386704599",["jquery.makeCollapsible","mediawiki.icon"]],["mediawiki.action.edit.preview","1386704599",[
"jquery.form","jquery.spinner","mediawiki.action.history.diff"]],["mediawiki.action.history","1386704617",[],"mediawiki.action.history"],["mediawiki.action.history.diff","1386704600",[],"mediawiki.action.history"],["mediawiki.action.view.dblClickEdit","1386704617",["mediawiki.page.startup","mediawiki.util"]],["mediawiki.action.view.metadata","1386902583"],["mediawiki.action.view.postEdit","1386902583",["jquery.cookie","mediawiki.jqueryMsg"]],["mediawiki.action.view.rightClickEdit","1386704617"],["mediawiki.action.edit.editWarning","1386902583"],["mediawiki.action.watch.ajax","1347062400",["mediawiki.page.watch.ajax"]],["mediawiki.language","1386704576",["mediawiki.cldr","mediawiki.language.data"]],["mediawiki.cldr","1386704576",["mediawiki.libs.pluralruleparser"]],["mediawiki.libs.pluralruleparser","1386704576"],["mediawiki.language.init","1386704576"],["mediawiki.jqueryMsg","1386704576",["mediawiki.language","mediawiki.util"]],["mediawiki.language.months","1386902583",[
"mediawiki.language"]],["mediawiki.libs.jpegmeta","1386704617"],["mediawiki.page.gallery","1386704617"],["mediawiki.page.ready","1386704617",["jquery.checkboxShiftClick","jquery.makeCollapsible","jquery.mw-jump","jquery.placeholder","mediawiki.util"]],["mediawiki.page.startup","1386704576",["jquery.client","mediawiki.util"]],["mediawiki.page.patrol.ajax","1386944611",["jquery.spinner","mediawiki.Title","mediawiki.api","mediawiki.notify","mediawiki.page.startup","mediawiki.util","user.tokens"]],["mediawiki.page.watch.ajax","1386902583",["jquery.mwExtension","mediawiki.api.watch","mediawiki.notify","mediawiki.page.startup","mediawiki.util"]],["mediawiki.page.image.pagination","1386704617",["jquery.spinner"]],["mediawiki.special","1386704617"],["mediawiki.special.block","1386704617",["mediawiki.util"]],["mediawiki.special.changeemail","1387043024",["mediawiki.util"]],["mediawiki.special.changeslist","1386704617"],["mediawiki.special.changeslist.enhanced","1386704617"],[
"mediawiki.special.movePage","1386704617",["jquery.byteLimit"]],["mediawiki.special.pagesWithProp","1386704617"],["mediawiki.special.preferences","1386704617"],["mediawiki.special.recentchanges","1386704617",["mediawiki.special"]],["mediawiki.special.search","1386902583"],["mediawiki.special.undelete","1386704617"],["mediawiki.special.upload","1386704617",["mediawiki.libs.jpegmeta","mediawiki.util"]],["mediawiki.special.userlogin","1386704586"],["mediawiki.special.createaccount","1386704617"],["mediawiki.special.createaccount.js","1386902583",["mediawiki.jqueryMsg"]],["mediawiki.special.javaScriptTest","1386704617",["jquery.qunit"]],["mediawiki.tests.qunit.testrunner","1386704617",["jquery.getAttrs","jquery.qunit","jquery.qunit.completenessTest","mediawiki.page.ready","mediawiki.page.startup"]],["mediawiki.legacy.ajax","1386704576",["mediawiki.legacy.wikibits","mediawiki.util"]],["mediawiki.legacy.commonPrint","1386704557"],["mediawiki.legacy.config","1386704617",[
"mediawiki.legacy.wikibits"]],["mediawiki.legacy.protect","1386704617",["jquery.byteLimit"]],["mediawiki.legacy.shared","1386704557"],["mediawiki.legacy.oldshared","1386704617"],["mediawiki.legacy.upload","1386704617",["jquery.spinner","mediawiki.Title","mediawiki.api","mediawiki.util"]],["mediawiki.legacy.wikibits","1386704576",["mediawiki.util"]],["mediawiki.ui","1386704586"],["oojs","1386704617"],["ext.gadget.colorcats","1386704617"],["ext.gadget.background-awesomeness","1386704617"],["ext.gadget.subject-pages","1386704617"],["ext.gadget.extlinks","1386704557",["mediawiki.util"]],["ext.gadget.navpop","1386704617"],["ext.gadget.Twinklerevert","1386704617",["mediawiki.util","jquery.ui.dialog","jquery.tipsy"]],["ext.gadget.twinklespeedy","1386704617",["mediawiki.util","jquery.ui.dialog","jquery.tipsy"]],["ext.gadget.twinklewarn","1386704617",["mediawiki.util","jquery.ui.dialog","jquery.tipsy"]],["ext.gadget.Twinkleunlink","1386704617",["mediawiki.util","jquery.ui.dialog","jquery.tipsy"
]],["ext.gadget.purge","1386704617",["mediawiki.util"]],["ext.gadget.bottomtabs","1386704617"],["ext.gadget.twinkledelimages","1386704617"],["mw.MwEmbedSupport","1386906394",["Spinner","jquery.loadingSpinner","jquery.mwEmbedUtil","jquery.triggerQueueCallback","mw.MwEmbedSupport.style"]],["Spinner","1386704609"],["iScroll","1386704617"],["jquery.loadingSpinner","1386704609"],["mw.MwEmbedSupport.style","1386704617"],["mediawiki.UtilitiesTime","1386704617"],["mediawiki.client","1386704617"],["mediawiki.absoluteUrl","1386704617"],["mw.ajaxProxy","1386704617"],["fullScreenApi","1386704617"],["jquery.embedMenu","1386704617"],["jquery.ui.touchPunch","1386704617",["jquery.ui.core","jquery.ui.mouse"]],["jquery.triggerQueueCallback","1386704609"],["jquery.mwEmbedUtil","1386704609"],["jquery.debouncedresize","1386704617"],["mw.Language.names","1386704617"],["mw.Api","1386704617"],["mw.MediaElement","1386704617"],["mw.MediaPlayer","1386704617"],["mw.MediaPlayers","1386704617",["mw.MediaPlayer"]],[
"mw.MediaSource","1386704617"],["mw.EmbedTypes","1386704617",["mediawiki.Uri","mw.MediaPlayers"]],["mw.EmbedPlayer","1386902583",["fullScreenApi","jquery.client","jquery.cookie","jquery.debouncedresize","jquery.embedMenu","jquery.hoverIntent","jquery.ui.mouse","jquery.ui.slider","jquery.ui.touchPunch","mediawiki.Uri","mediawiki.UtilitiesTime","mediawiki.absoluteUrl","mediawiki.client","mediawiki.jqueryMsg","mw.EmbedPlayerNative","mw.EmbedTypes","mw.MediaElement","mw.MediaPlayers","mw.MediaSource","mw.PlayerSkinKskin"]],["mw.EmbedPlayerKplayer","1386704617"],["mw.EmbedPlayerGeneric","1386704617"],["mw.EmbedPlayerJava","1386704617"],["mw.EmbedPlayerNative","1386704617"],["mw.EmbedPlayerImageOverlay","1386704617"],["mw.EmbedPlayerVlc","1386704617"],["mw.PlayerSkinKskin","1386704617"],["mw.PlayerSkinMvpcf","1386704617"],["mw.TimedText","1386902583",["jquery.ui.dialog","mw.EmbedPlayer","mw.TextSource"]],["mw.TextSource","1386704617",["mediawiki.UtilitiesTime","mw.ajaxProxy"]],[
"ext.wikihiero","1386704557"],["ext.wikihiero.Special","1386704617",["jquery.spinner"]],["ext.cite","1386902583"],["ext.cite.popups","1386704617",["jquery.tooltip"]],["jquery.tooltip","1386704617"],["ext.rtlcite","1386704557"],["ext.specialcite","1386704617"],["ext.geshi.local","1386704616"],["ext.flaggedRevs.basic","1386704579"],["ext.flaggedRevs.advanced","1386902583",["mediawiki.util"]],["ext.flaggedRevs.review","1386902583",["mediawiki.jqueryMsg","mediawiki.user","mediawiki.util"]],["ext.categoryTree","1386902583"],["ext.categoryTree.css","1386704617"],["mediawiki.api.titleblacklist","1386704617",["mediawiki.api"]],["ext.quiz","1386704617"],["ext.nuke","1386704617"],["ext.confirmEdit.fancyCaptcha.styles","1386704617"],["ext.confirmEdit.fancyCaptcha","1386704617",["mediawiki.api"]],["ext.confirmEdit.fancyCaptchaMobile","1386704617",["mobile.startup"]],["ext.centralauth","1387049325",["jquery.spinner","mediawiki.util"]],["ext.centralauth.centralautologin","1386704575",[
"mediawiki.jqueryMsg","mediawiki.notify"]],["ext.centralauth.centralautologin.clearcookie","1386704617"],["ext.centralauth.noflash","1386704617"],["ext.centralauth.globalusers","1386704617"],["ext.centralauth.globalgrouppermissions","1386704617"],["ext.dismissableSiteNotice","1386704617",["jquery.cookie","mediawiki.util"]],["jquery.ui.multiselect","1386704617",["jquery.ui.core","jquery.ui.draggable","jquery.ui.droppable","jquery.ui.sortable","mediawiki.jqueryMsg"]],["ext.centralNotice.adminUi","1386704617",["jquery.ui.datepicker","jquery.ui.multiselect"]],["ext.centralNotice.adminUi.bannerManager","1386704617",["ext.centralNotice.adminUi","jquery.ui.dialog"]],["ext.centralNotice.adminUi.bannerEditor","1386704617",["ext.centralNotice.adminUi","jquery.ui.dialog"]],["ext.centralNotice.bannerStats","1386704617"],["ext.centralNotice.bannerController","1386704575",["jquery.cookie"]],["ext.centralNotice.adminUi.campaignManager","1386704617",["ext.centralNotice.adminUi","jquery.ui.dialog",
"jquery.ui.slider"]],["ext.collection.jquery.jstorage","1386704617",["jquery.json"]],["ext.collection.suggest","1386704617",["ext.collection.bookcreator"]],["ext.collection","1386714685",["ext.collection.bookcreator","jquery.ui.sortable"]],["ext.collection.bookcreator","1386893382",["ext.collection.jquery.jstorage"]],["ext.collection.checkLoadFromLocalStorage","1386893382",["ext.collection.jquery.jstorage"]],["ext.abuseFilter","1386704617"],["ext.abuseFilter.edit","1386704617",["jquery.spinner","jquery.textSelection","mediawiki.api","mediawiki.util"]],["ext.abuseFilter.tools","1386704617",["jquery.spinner","mediawiki.api","mediawiki.notify","user.tokens"]],["ext.abuseFilter.examine","1386704617",["jquery.spinner","mediawiki.api"]],["contentCollector","1386704617",[],"ext.wikiEditor"],["jquery.wikiEditor","1386902583",["jquery.client","jquery.delayedBind","jquery.textSelection"],"ext.wikiEditor"],["jquery.wikiEditor.iframe","1386704617",["contentCollector","jquery.wikiEditor"],
"ext.wikiEditor"],["jquery.wikiEditor.dialogs","1386704617",["jquery.tabIndex","jquery.ui.button","jquery.ui.dialog","jquery.ui.draggable","jquery.ui.resizable","jquery.wikiEditor","jquery.wikiEditor.toolbar"],"ext.wikiEditor"],["jquery.wikiEditor.dialogs.config","1386902583",["jquery.suggestions","jquery.wikiEditor","jquery.wikiEditor.dialogs","jquery.wikiEditor.toolbar.i18n","mediawiki.Title","mediawiki.jqueryMsg"],"ext.wikiEditor"],["jquery.wikiEditor.highlight","1386704617",["jquery.wikiEditor","jquery.wikiEditor.iframe"],"ext.wikiEditor"],["jquery.wikiEditor.preview","1386704617",["jquery.wikiEditor"],"ext.wikiEditor"],["jquery.wikiEditor.previewDialog","1386704617",["jquery.wikiEditor","jquery.wikiEditor.dialogs"],"ext.wikiEditor"],["jquery.wikiEditor.publish","1386704617",["jquery.wikiEditor","jquery.wikiEditor.dialogs"],"ext.wikiEditor"],["jquery.wikiEditor.templateEditor","1386704617",["jquery.wikiEditor","jquery.wikiEditor.dialogs","jquery.wikiEditor.iframe"],"ext.wikiEditor"
],["jquery.wikiEditor.templates","1386704617",["jquery.wikiEditor","jquery.wikiEditor.iframe"],"ext.wikiEditor"],["jquery.wikiEditor.toc","1386704617",["jquery.autoEllipsis","jquery.color","jquery.ui.draggable","jquery.ui.resizable","jquery.wikiEditor","jquery.wikiEditor.iframe"],"ext.wikiEditor"],["jquery.wikiEditor.toolbar","1386704617",["jquery.wikiEditor","jquery.wikiEditor.toolbar.i18n"],"ext.wikiEditor"],["jquery.wikiEditor.toolbar.config","1386704617",["jquery.async","jquery.cookie","jquery.wikiEditor","jquery.wikiEditor.toolbar","jquery.wikiEditor.toolbar.i18n"],"ext.wikiEditor"],["jquery.wikiEditor.toolbar.i18n","1347062400",[],"ext.wikiEditor"],["ext.wikiEditor","1386704617",["jquery.wikiEditor"],"ext.wikiEditor"],["ext.wikiEditor.dialogs","1386704617",["ext.wikiEditor","ext.wikiEditor.toolbar","jquery.wikiEditor.dialogs","jquery.wikiEditor.dialogs.config"],"ext.wikiEditor"],["ext.wikiEditor.highlight","1386704617",["ext.wikiEditor","jquery.wikiEditor.highlight"],
"ext.wikiEditor"],["ext.wikiEditor.preview","1386704617",["ext.wikiEditor","jquery.wikiEditor.preview"],"ext.wikiEditor"],["ext.wikiEditor.previewDialog","1386704617",["ext.wikiEditor","jquery.wikiEditor.previewDialog"],"ext.wikiEditor"],["ext.wikiEditor.publish","1386704617",["ext.wikiEditor","jquery.wikiEditor.publish"],"ext.wikiEditor"],["ext.wikiEditor.templateEditor","1386704617",["ext.wikiEditor","ext.wikiEditor.highlight","jquery.wikiEditor.templateEditor"],"ext.wikiEditor"],["ext.wikiEditor.templates","1386704617",["ext.wikiEditor","ext.wikiEditor.highlight","jquery.wikiEditor.templates"],"ext.wikiEditor"],["ext.wikiEditor.toc","1386704617",["ext.wikiEditor","ext.wikiEditor.highlight","jquery.wikiEditor.toc"],"ext.wikiEditor"],["ext.wikiEditor.tests.toolbar","1386704617",["ext.wikiEditor.toolbar"],"ext.wikiEditor"],["ext.wikiEditor.toolbar","1386704617",["ext.wikiEditor","jquery.wikiEditor.toolbar","jquery.wikiEditor.toolbar.config"],"ext.wikiEditor"],[
"ext.wikiEditor.toolbar.hideSig","1386704617",[],"ext.wikiEditor"],["ext.MassMessage.special.js","1386704617",["jquery.byteLimit","jquery.delayedBind","jquery.ui.autocomplete","mediawiki.jqueryMsg"]],["ext.MassMessage.special","1386704617"],["ext.betaFeatures","1386704617",["jquery.client"]],["ext.betaFeatures.popup","1386704617",["jquery.tipsy"]],["multilightbox.interface","1386704617"],["multilightbox.image","1386704617"],["multilightbox","1386704617",["ext.multimediaViewer.lightboxinterface"]],["ext.multimediaViewer.lightboximage","1386704617",["multilightbox.image","oojs"]],["ext.multimediaViewer.lightboxinterface","1386894266",["multilightbox.interface","oojs"]],["ext.multimediaViewer","1386905258",["ext.eventLogging","ext.multimediaViewer.lightboximage","jquery.hidpi","jquery.spinner","jquery.ui.dialog","mediawiki.Title","momentjs","multilightbox","schema.MediaViewer"]],["momentjs","1386704617"],["ext.templateData","1386704617"],["mobile.templates","1386704617"],["mobile.bridge",
"1386268280"],["mobile.loggingSchemas","1386268280",["mobile.startup"]],["mobile.file.scripts","1386268280",["mobile.startup"]],["mobile.styles.page","1386268280",["mobile.startup"]],["mobile.pagelist.styles","1386268280"],["mobile.styles","1386268280"],["mobile.styles.beta","1386268280"],["mobile.head","1386268280"],["mobile.head.beta","1386268280",["mediawiki.jqueryMsg","mediawiki.language","mobile.head"]],["mobile.startup","1386268280",["mobile.head","mobile.templates"]],["mobile.editor","1386268280",["mobile.overlays","mobile.stable.common"]],["mobile.editor.beta","1386268280",["mobile.overlays.beta","mobile.stable.common"]],["mobile.editor.common","1386268280",["jquery.cookie","mobile.stable","mobile.templates"]],["mobile.editor.overlay.stable","1386268280",["mobile.editor.common"]],["mobile.editor.overlay.beta","1386268280",["mobile.editor.common"]],["mobile.uploads.tutorial","1386268280",["mobile.stable","mobile.templates"]],["mobile.uploads.common","1386268280",["mobile.stable"
,"mobile.templates","mobile.uploads.tutorial"]],["mobile.uploads","1386268280",["mobile.stable","mobile.templates","mobile.uploads.common"]],["mobile.uploadsNew","1386268280",["mobile.stable","mobile.templates","mobile.uploads.common"]],["mobile.beta.common","1386268280",["mobile.loggingSchemas","mobile.stable.common","mobile.templates"]],["mobile.keepgoing","1386268280",["mobile.beta","mobile.templates"]],["mobile.geonotahack","1386268280",["mobile.loggingSchemas","mobile.stable.common","mobile.startup"]],["mobile.beta","1386268280",["mobile.beta.common","mobile.overlays.beta","mobile.stable"]],["mobile.search.beta","1386268280",["mobile.beta"]],["mobile.talk","1386268280",["mobile.beta","mobile.templates"]],["mobile.alpha","1386268280",["mobile.beta","mobile.stable","mobile.templates"]],["mobile.toast.styles","1386268280"],["mobile.stable.styles","1386268280"],["mobile.overlays","1386268280",["mobile.startup","mobile.templates"]],["mobile.overlays.beta","1386268280",[
"mobile.overlays"]],["mobile.stable.common","1386268280",["mediawiki.jqueryMsg","mediawiki.util","mobile.overlays","mobile.startup","mobile.templates","mobile.toast.styles"]],["mobile.lastEdited.stable","1386268280",["mobile.stable"]],["mobile.references","1386268280",["mobile.stable.common","mobile.startup","mobile.templates"]],["mobile.stable","1386268280",["mediawiki.language","mediawiki.util","mobile.references","mobile.stable.common","mobile.stable.styles","mobile.startup","mobile.templates"]],["mobile.search.stable","1386268280",["mobile.stable","mobile.templates"]],["mobile.languages","1386268280",["mobile.overlays"]],["mobile.languages.beta","1386268280",["mobile.overlays.beta"]],["mobile.issues","1386268280",["mobile.overlays"]],["mobile.issues.beta","1386268280",["mobile.overlays.beta"]],["mobile.desktop","1386704617",["jquery.cookie"]],["mobile.nearby.styles","1386268280"],["mobile.nearby.beta","1386268280",["mobile.beta.common","mobile.nearby","mobile.stable.common"]],[
"mobile.nearby","1386268280",["jquery.json","mediawiki.language","mobile.loggingSchemas","mobile.nearby.styles","mobile.stable.common","mobile.templates"]],["mobile.nearby.scripts","1386268280",["mobile.nearby"]],["mobile.notifications","1386268280",["mobile.overlays"]],["mobile.notifications.beta","1386268280",["mobile.overlays.beta"]],["mobile.notifications.overlay","1386268280",["ext.echo.base","mobile.stable"]],["mobile.notifications.overlay.beta","1386268280",["mobile.notifications.overlay","mobile.overlays.beta"]],["mobile.userprofile.scripts","1386268280",["mobile.editor.common","mobile.stable.common"]],["mobile.uploads.scripts","1386268280",["mobile.stable.common","mobile.stable.styles","mobile.templates","mobile.uploads.tutorial"]],["mobile.mobilediff.scripts","1386268280",["mobile.loggingSchemas","mobile.stable.common"]],["mobile.mobilediff.scripts.beta.head","1386268280",["mobile.head"]],["ext.math.mathjax","1386704617",[],"ext.math.mathjax"],["ext.math.mathjax.enabler",
"1386704617"],["ext.babel","1386704617"],["ext.vipsscaler","1386704617",["jquery.ucompare"]],["jquery.ucompare","1386704617"],["ext.apiSandbox","1386704617",["jquery.ui.button","mediawiki.util"]],["ext.interwiki.specialpage","1386704617",["jquery.makeCollapsible"]],["ext.echo.base","1386902583",["schema.Echo","schema.EchoInteraction","schema.EchoMail"]],["ext.echo.desktop","1386704599",["ext.echo.base","mediawiki.Uri","mediawiki.api","mediawiki.jqueryMsg","mediawiki.user"]],["ext.echo.overlay","1386902583",["ext.echo.desktop","mediawiki.language","mediawiki.util"]],["ext.echo.special","1386932802",["ext.echo.desktop","mediawiki.ui"]],["ext.echo.alert","1386902583"],["ext.echo.badge","1386704597"],["ext.thanks","1386902583",["jquery.ui.dialog","mediawiki.api","mediawiki.jqueryMsg","user.tokens"]],["ext.thanks.mobilediff","1387036943",["mobile.mobilediff.scripts"]],["ext.codeEditor","1386704617",["ext.wikiEditor.toolbar","jquery.codeEditor"],"ext.wikiEditor"],["jquery.codeEditor",
"1386951055",["ext.codeEditor.ace","jquery.ui.resizable","jquery.wikiEditor"],"ext.wikiEditor"],["ext.codeEditor.ace","1386704617",[],"ext.codeEditor.ace"],["ext.codeEditor.ace.modes","1386704617",["ext.codeEditor.ace"],"ext.codeEditor.ace"],["ext.codeEditor.geshi","1386704617",[],"ext.wikiEditor"],["ext.scribunto","1386704617",["jquery.ui.dialog"]],["ext.scribunto.edit","1386704617",["ext.scribunto","mediawiki.api"]],["ext.eventLogging","1386704617",["jquery.json","mediawiki.util"]],["ext.eventLogging.jsonSchema","1386704617"],["ext.campaigns","1386704617",["jquery.cookie"]],["schema.VisualEditorDOMRetrieved","1347062400",["ext.eventLogging"]],["schema.VisualEditorDOMSaved","1347062400",["ext.eventLogging"]],["schema.ModuleStorage","1347062400",["ext.eventLogging"]],["ext.wikimediaEvents.ve","1386704617",["ext.visualEditor.viewPageTarget.init"]],["ext.wikimediaEvents.moduleStorage","1386704617",["mediawiki.inspect","schema.ModuleStorage"]],["schema.NavigationTiming","1347062400",[
"ext.eventLogging"]],["ext.navigationTiming","1386704617",["schema.NavigationTiming"]],["ext.uls.languagenames","1386098064"],["ext.uls.messages","1386268374",["ext.uls.i18n"]],["ext.uls.buttons","1386704617"],["ext.uls.displaysettings","1386704617",["ext.uls.buttons","ext.uls.languagesettings","ext.uls.mediawiki","ext.uls.webfonts","jquery.i18n","mediawiki.api.parse"]],["ext.uls.geoclient","1386704617"],["ext.uls.ime","1386902583",["ext.uls.init","ext.uls.mediawiki","ext.uls.preferences","jquery.ime"]],["ext.uls.nojs","1386704557"],["ext.uls.init","1386704575",["ext.uls.messages","jquery.client","jquery.cookie","jquery.json","mediawiki.Uri"]],["ext.uls.eventlogger","1386704617",["schema.UniversalLanguageSelector"]],["ext.uls.i18n","1386704575",["jquery.i18n","mediawiki.util"]],["ext.uls.inputsettings","1386704617",["ext.uls.buttons","ext.uls.ime","ext.uls.languagesettings","ext.uls.mediawiki","jquery.i18n","jquery.ime"]],["ext.uls.interface","1386902583",["ext.uls.init",
"ext.uls.webfonts","jquery.tipsy","mediawiki.user"]],["ext.uls.languagesettings","1386704617",["ext.uls.buttons","ext.uls.preferences","jquery.uls.grid"]],["ext.uls.preferences","1386704575",["jquery.jStorage","mediawiki.api","mediawiki.user"]],["ext.uls.webfonts","1386704575",["ext.uls.init","ext.uls.preferences","ext.uls.webfonts.repository","jquery.webfonts"]],["ext.uls.webfonts.repository","1386704575"],["jquery.i18n","1386704575",["mediawiki.libs.pluralruleparser"]],["jquery.ime","1386704617"],["ext.uls.mediawiki","1386704617",["ext.uls.languagenames","jquery.i18n","jquery.uls","mediawiki.util"]],["jquery.uls","1386704576",["jquery.i18n","jquery.uls.data","jquery.uls.grid"]],["jquery.uls.compact","1386704617",["jquery.uls"]],["jquery.uls.data","1386704576"],["jquery.uls.grid","1386704576"],["jquery.webfonts","1386704576"],["rangy.core","1386704617"],["ext.TemplateSandbox","1386704617"],["ext.MWOAuth.BasicStyles","1386704617"],["ext.MWOAuth.AuthorizeForm","1386704617"],[
"ext.MWOAuth.AuthorizeDialog","1386704617",["jquery.ui.dialog"]],["ext.MWOAuth.WikiSelect","1386704617",["jquery.ui.autocomplete"]],["ext.checkUser","1386704617",["mediawiki.util"]],["mw.PopUpMediaTransform","1386876295",["mw.MwEmbedSupport"]],["mw.TMHGalleryHook.js","1386704617"],["embedPlayerIframeStyle","1386704617"],["ext.tmh.transcodetable","1386943545"],["mw.MediaWikiPlayerSupport","1386704617",["mw.Api"]],["schema.MediaViewer","1347062400",["ext.eventLogging"]],["schema.UniversalLanguageSelector","1347062400",["ext.eventLogging"]],["mobile.uploads.schema","1347062400",["ext.eventLogging"]],["mobile.watchlist.schema","1347062400",["ext.eventLogging"]],["mobile.editing.schema","1347062400",["ext.eventLogging"]],["schema.MobileWebCta","1347062400",["ext.eventLogging"]],["schema.MobileWebClickTracking","1347062400",["ext.eventLogging"]],["schema.Echo","1347062400",["ext.eventLogging"]],["schema.EchoMail","1347062400",["ext.eventLogging"]],["schema.EchoInteraction","1347062400",[
"ext.eventLogging"]]]);mw.config.set({"wgLoadScript":"//bits.wikimedia.org/en.wikibooks.org/load.php","debug":false,"skin":"vector","stylepath":"//bits.wikimedia.org/static-1.23wmf6/skins","wgUrlProtocols":"http\\:\\/\\/|https\\:\\/\\/|ftp\\:\\/\\/|ftps\\:\\/\\/|ssh\\:\\/\\/|sftp\\:\\/\\/|irc\\:\\/\\/|ircs\\:\\/\\/|xmpp\\:|sip\\:|sips\\:|gopher\\:\\/\\/|telnet\\:\\/\\/|nntp\\:\\/\\/|worldwind\\:\\/\\/|mailto\\:|tel\\:|sms\\:|news\\:|svn\\:\\/\\/|git\\:\\/\\/|mms\\:\\/\\/|bitcoin\\:|magnet\\:|urn\\:|geo\\:|\\/\\/","wgArticlePath":"/wiki/$1","wgScriptPath":"/w","wgScriptExtension":".php","wgScript":"/w/index.php","wgVariantArticlePath":false,"wgActionPaths":{},"wgServer":"//en.wikibooks.org","wgUserLanguage":"en","wgContentLanguage":"en","wgVersion":"1.23wmf6","wgEnableAPI":true,"wgEnableWriteAPI":true,"wgMainPageTitle":"Main Page","wgFormattedNamespaces":{"-2":"Media","-1":"Special","0":"","1":"Talk","2":"User","3":"User talk","4":"Wikibooks","5":"Wikibooks talk","6":"File","7":
"File talk","8":"MediaWiki","9":"MediaWiki talk","10":"Template","11":"Template talk","12":"Help","13":"Help talk","14":"Category","15":"Category talk","102":"Cookbook","103":"Cookbook talk","108":"Transwiki","109":"Transwiki talk","110":"Wikijunior","111":"Wikijunior talk","112":"Subject","113":"Subject talk","828":"Module","829":"Module talk"},"wgNamespaceIds":{"media":-2,"special":-1,"":0,"talk":1,"user":2,"user_talk":3,"wikibooks":4,"wikibooks_talk":5,"file":6,"file_talk":7,"mediawiki":8,"mediawiki_talk":9,"template":10,"template_talk":11,"help":12,"help_talk":13,"category":14,"category_talk":15,"cookbook":102,"cookbook_talk":103,"transwiki":108,"transwiki_talk":109,"wikijunior":110,"wikijunior_talk":111,"subject":112,"subject_talk":113,"module":828,"module_talk":829,"wb":4,"wj":110,"cat":14,"cook":102,"sub":112,"image":6,"image_talk":7,"project":4,"project_talk":5},"wgContentNamespaces":[102,110,0],"wgSiteName":"Wikibooks","wgFileExtensions":["png","gif","jpg","jpeg","tiff","tif",
"xcf","pdf","mid","ogg","ogv","svg","djvu","oga","flac","wav","webm"],"wgDBname":"enwikibooks","wgFileCanRotate":true,"wgAvailableSkins":{"monobook":"MonoBook","vector":"Vector","modern":"Modern","cologneblue":"CologneBlue"},"wgExtensionAssetsPath":"//bits.wikimedia.org/static-1.23wmf6/extensions","wgCookiePrefix":"enwikibooks","wgResourceLoaderMaxQueryLength":-1,"wgCaseSensitiveNamespaces":[],"wgLegalTitleChars":" %!\"$\u0026'()*,\\-./0-9:;=?@A-Z\\\\\\^_`a-z~+\\u0080-\\uFFFF","wgResourceLoaderStorageVersion":1,"wgResourceLoaderStorageEnabled":false,"EmbedPlayer.DirectFileLinkWarning":true,"EmbedPlayer.EnableOptionsMenu":true,"EmbedPlayer.DisableJava":false,"EmbedPlayer.DisableHTML5FlashFallback":true,"TimedText.ShowInterface":"always","TimedText.ShowAddTextLink":true,"EmbedPlayer.WebPath":"//bits.wikimedia.org/static-1.23wmf6/extensions/TimedMediaHandler/MwEmbedModules/EmbedPlayer","wgCortadoJarFile":false,"TimedText.ShowInterface.local":"off","AjaxRequestTimeout":30,
"MediaWiki.DefaultProvider":"local","MediaWiki.ApiProviders":{"wikimediacommons":{"url":"//commons.wikimedia.org/w/api.php"}},"MediaWiki.ApiPostActions":["login","purge","rollback","delete","undelete","protect","block","unblock","move","edit","upload","emailuser","import","userrights"],"EmbedPlayer.OverlayControls":true,"EmbedPlayer.CodecPreference":["webm","h264","ogg"],"EmbedPlayer.DisableVideoTagSupport":false,"EmbedPlayer.ReplaceSources":null,"EmbedPlayer.EnableFlavorSelector":false,"EmbedPlayer.EnableIpadHTMLControls":true,"EmbedPlayer.WebKitPlaysInline":false,"EmbedPlayer.EnableIpadNativeFullscreen":false,"EmbedPlayer.iPhoneShowHTMLPlayScreen":true,"EmbedPlayer.ForceLargeReplayButton":false,"EmbedPlayer.LibraryPage":"http://www.kaltura.org/project/HTML5_Video_Media_JavaScript_Library","EmbedPlayer.RewriteSelector":"video,audio,playlist","EmbedPlayer.DefaultSize":"400x300","EmbedPlayer.ControlsHeight":31,"EmbedPlayer.TimeDisplayWidth":85,"EmbedPlayer.KalturaAttribution":true,
"EmbedPlayer.AttributionButton":{"title":"Kaltura html5 video library","href":"http://www.kaltura.com","class":"kaltura-icon","style":[],"iconurl":false},"EmbedPlayer.EnableRightClick":true,"EmbedPlayer.EnabledOptionsMenuItems":["playerSelect","download","share","aboutPlayerLibrary"],"EmbedPlayer.WaitForMeta":true,"EmbedPlayer.ShowNativeWarning":true,"EmbedPlayer.ShowPlayerAlerts":true,"EmbedPlayer.EnableFullscreen":true,"EmbedPlayer.EnableTimeDisplay":true,"EmbedPlayer.EnableVolumeControl":true,"EmbedPlayer.NewWindowFullscreen":false,"EmbedPlayer.FullscreenTip":true,"EmbedPlayer.FirefoxLink":"http://www.mozilla.com/en-US/firefox/upgrade.html?from=mwEmbed","EmbedPlayer.NativeControls":false,"EmbedPlayer.NativeControlsMobileSafari":true,"EmbedPlayer.FullScreenZIndex":999998,"EmbedPlayer.ShareEmbedMode":"iframe","EmbedPlayer.SkinList":["mvpcf","kskin"],"EmbedPlayer.DefaultSkin":"mvpcf","EmbedPlayer.MonitorRate":250,"EmbedPlayer.UseFlashOnAndroid":false,"EmbedPlayer.EnableURLTimeEncoding"
:"flash","EmbedPLayer.IFramePlayer.DomainWhiteList":"*","EmbedPlayer.EnableIframeApi":true,"EmbedPlayer.PageDomainIframe":true,"EmbedPlayer.NotPlayableDownloadLink":true,"EmbedPlayer.BlackPixel":"data:image/png,%89PNG%0D%0A%1A%0A%00%00%00%0DIHDR%00%00%00%01%00%00%00%01%08%02%00%00%00%90wS%DE%00%00%00%01sRGB%00%AE%CE%1C%E9%00%00%00%09pHYs%00%00%0B%13%00%00%0B%13%01%00%9A%9C%18%00%00%00%07tIME%07%DB%0B%0A%17%041%80%9B%E7%F2%00%00%00%19tEXtComment%00Created%20with%20GIMPW%81%0E%17%00%00%00%0CIDAT%08%D7c%60%60%60%00%00%00%04%00%01'4'%0A%00%00%00%00IEND%AEB%60%82","TimedText.ShowRequestTranscript":false,"TimedText.NeedsTranscriptCategory":"Videos needing subtitles","TimedText.BottomPadding":10,"TimedText.BelowVideoBlackBoxHeight":40,"wgCentralAuthCheckLoggedInURL":"//login.wikimedia.org/wiki/Special:CentralAutoLogin/checkLoggedIn?type=script\u0026wikiid=enwikibooks","wgWikiEditorMagicWords":{"redirect":"#REDIRECT","img_right":"right","img_left":"left","img_none":"none","img_center":"center"
,"img_thumbnail":"thumbnail","img_framed":"framed","img_frameless":"frameless"},"wgMultimediaViewer":{"infoLink":"//mediawiki.org/wiki/Special:MyLanguage/Multimedia/About_Media_Viewer","discussionLink":"//mediawiki.org/wiki/Special:MyLanguage/Talk:Multimedia/About_Media_Viewer"},"wgStopMobileRedirectCookie":{"name":"stopMobileRedirect","duration":30,"domain":".wikibooks.org","path":"/"},"wgMFNearbyEndpoint":"","wgMFNearbyNamespace":0,"wgEventLoggingBaseUri":"//bits.wikimedia.org/event.gif","wgNavigationTimingSamplingFactor":1000,"wgULSIMEEnabled":true,"wgULSPosition":"interlanguage","wgULSAnonCanChangeLanguage":false,"wgULSEventLogging":true,"wgULSImeSelectors":["input:not([type])","input[type=text]","input[type=search]","textarea","[contenteditable]"],"wgULSNoImeSelectors":["#wpCaptchaWord",".ve-ce-documentNode",".ace_editor textarea"],"wgULSNoWebfontsSelectors":[".autonym"],"wgULSCurrentAutonym":"English","wgULSFontRepositoryBasePath":
"https://bits.wikimedia.org/static-current/extensions/UniversalLanguageSelector/data/fontrepo/fonts/","wgNoticeFundraisingUrl":"https://donate.wikimedia.org/wiki/Special:LandingCheck","wgCentralPagePath":"//meta.wikimedia.org/w/index.php","wgCentralBannerDispatcher":"//meta.wikimedia.org/wiki/Special:BannerRandom","wgCentralBannerRecorder":"//meta.wikimedia.org/wiki/Special:RecordImpression","wgNoticeXXCountries":["XX","EU","AP","A1","A2","O1"],"wgNoticeNumberOfBuckets":4,"wgNoticeBucketExpiry":7,"wgNoticeNumberOfControllerBuckets":2,"wgNoticeCookieShortExpiry":1209600,"wgNoticeHideUrls":[]});};if(isCompatible()){document.write("\u003Cscript src=\"//bits.wikimedia.org/en.wikibooks.org/load.php?debug=false\u0026amp;lang=en\u0026amp;modules=jquery%2Cmediawiki%2CSpinner%7Cjquery.triggerQueueCallback%2CloadingSpinner%2CmwEmbedUtil%7Cmw.MwEmbedSupport\u0026amp;only=scripts\u0026amp;skin=vector\u0026amp;version=20131213T034634Z\"\u003E\u003C/script\u003E");}delete isCompatible;
/* cache key: enwikibooks:resourceloader:filter:minify-js:7:31f4c95ec4d818855e0abdb6b4d36f93 */