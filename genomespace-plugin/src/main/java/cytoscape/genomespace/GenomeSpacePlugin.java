package cytoscape.genomespace;

import cytoscape.Cytoscape;
import cytoscape.plugin.CytoscapePlugin;
import org.genomespace.sws.SimpleWebServer; 
import javax.swing.JMenu; 


/**
 * This class is used to instantiate your plugin. Put whatever initialization code
 * you need into the no argument constructor (the only one that will be called).
 * The actual functionality of your plugin can be in this class, but should 
 * probably be separated into separted classes that get instantiated here.
 */
public class GenomeSpacePlugin extends CytoscapePlugin {

	public GenomeSpacePlugin() {
		// Properly initializes things.
		super();

		SimpleWebServer sws = new SimpleWebServer(60161);
		sws.registerListener(new LoadNetworkFromURL());
		sws.registerListener(new LoadCyTableFromURL("node.cytable",Cytoscape.getNodeAttributes()));
		sws.registerListener(new LoadCyTableFromURL("edge.cytable",Cytoscape.getEdgeAttributes()));
		sws.registerListener(new LoadSessionFromURL());
		sws.start();

		// This action represents the actual behavior of the plugin.
		UploadFileToGenomeSpace uploadAction = new UploadFileToGenomeSpace();
		Cytoscape.getDesktop().getCyMenus().addAction(uploadAction);

		DeleteFileInGenomeSpace deleteAction = new DeleteFileInGenomeSpace();
		Cytoscape.getDesktop().getCyMenus().addAction(deleteAction);

		DownloadFileFromGenomeSpace downloadAction = new DownloadFileFromGenomeSpace();
		Cytoscape.getDesktop().getCyMenus().addAction(downloadAction);

		ListFilesInGenomeSpace listAction = new ListFilesInGenomeSpace();
		Cytoscape.getDesktop().getCyMenus().addAction(listAction);

		LoadNetworkFromGenomeSpace loadNetworkAction = new LoadNetworkFromGenomeSpace();
		Cytoscape.getDesktop().getCyMenus().addAction(loadNetworkAction);

		LoadTableNetworkFromGenomeSpace loadTableNetworkAction =
			new LoadTableNetworkFromGenomeSpace();
		Cytoscape.getDesktop().getCyMenus().addAction(loadTableNetworkAction);

		LoadAttrsFromGenomeSpace loadAttrsAction = new LoadAttrsFromGenomeSpace();
		Cytoscape.getDesktop().getCyMenus().addAction(loadAttrsAction);

		LoadCyTableFromGenomeSpace loadCyTableAction = new LoadCyTableFromGenomeSpace();
		Cytoscape.getDesktop().getCyMenus().addAction(loadCyTableAction);

		LoadTableAttrsFromGenomeSpace loadTableAttrsAction =
			new LoadTableAttrsFromGenomeSpace();
		Cytoscape.getDesktop().getCyMenus().addAction(loadTableAttrsAction);

		LoadSessionFromGenomeSpace loadSessionAction = new LoadSessionFromGenomeSpace();
		Cytoscape.getDesktop().getCyMenus().addAction(loadSessionAction);

		SaveSessionToGenomeSpace saveSessionAction = new SaveSessionToGenomeSpace();
		Cytoscape.getDesktop().getCyMenus().addAction(saveSessionAction);

		SaveNetworkToGenomeSpace saveNetworkAction = new SaveNetworkToGenomeSpace();
		Cytoscape.getDesktop().getCyMenus().addAction(saveNetworkAction);

		LoadOntologyAndAnnotationFromGenomeSpace loadOntologyAndAnnotationFromGenomeSpace =
			new LoadOntologyAndAnnotationFromGenomeSpace();
		Cytoscape.getDesktop().getCyMenus().addAction(loadOntologyAndAnnotationFromGenomeSpace);

		LoginToGenomeSpace loginToGenomeSpace = new LoginToGenomeSpace();
		Cytoscape.getDesktop().getCyMenus().addAction(loginToGenomeSpace);

		JMenu gsMenu = Cytoscape.getDesktop().getCyMenus().getMenuBar().getMenu("File.GenomeSpace");
		LaunchToolMenu ltm = new LaunchToolMenu(gsMenu);
		gsMenu.add(ltm);
		
		
	}
}	
