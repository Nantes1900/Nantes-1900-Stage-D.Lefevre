package algos;

import java.io.File;

import javax.vecmath.Vector3d;

import utils.MatrixMethod;
import utils.Parser;
import utils.Writer;

import modeles.Mesh;


public class TestDeMerde {
	public static void main(String[] args) {
		try
		{
			Mesh mesh = new Mesh(Parser.readSTLA(new File("batiment5.stl")));
			
			Mesh sol = new Mesh(Parser.readSTLA(new File("sol.stl")));

			//Normale sol
			Vector3d normalSol = sol.averageNormal();
			
			Mesh meshreuh = mesh.orientesNormalA(normalSol, 0.1);
			
			Vector3d vect = meshreuh.getOne().normale;
			Vector3d vect2 = new Vector3d();
			vect2.cross(vect, normalSol);
			
			double[][] matrix = MatrixMethod.createOrthoBase(vect2, vect, normalSol);
			Mesh mesh2 = mesh.changeBase(matrix);
			double[][] matrixInv = MatrixMethod.getInversMatrix(matrix);
			Mesh mesh3 = mesh2.changeBase(matrixInv);
			Writer.ecrireSurfaceA(new File("matrix1.stl"), mesh);
			Writer.ecrireSurfaceA(new File("matrix2.stl"), mesh2);
			Writer.ecrireSurfaceA(new File("matrix3.stl"), mesh3);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
