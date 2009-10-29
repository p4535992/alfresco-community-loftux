script:
{
    // locate node
    var pathSegments = url.match.split("/");
    var reference = [ url.templateArgs.store_type, url.templateArgs.store_id ].concat(url.templateArgs.id.split("/"));
    var node = cmis.findNode(pathSegments[2], reference);
    if (node === null)
    {
        status.code = 404;
        status.message = "Repository " + pathSegments[2] + " " + reference.join("/") + " not found";
        status.redirect = true;
        break script;
    }

    // locate parent
    if (node.id == cmis.defaultRootFolder.id)
    {
        status.code = 404;
        status.message = "Repository " + pathSegments[2] + " " + reference.join("/") + " parent not found";
        status.redirect = true;
        break script;
    }
    model.node = node.parent;
 
    // property filter 
    model.filter = args[cmis.ARG_FILTER];
    if (model.filter === null)
    {
        model.filter = "*";
    }
   
    // include allowable actions
    var includeAllowableActions = args[cmis.ARG_INCLUDE_ALLOWABLE_ACTIONS];
    model.includeAllowableActions = (includeAllowableActions == "true" ? true : false);
}
