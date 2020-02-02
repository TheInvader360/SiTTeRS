package com.theinvader360.sitters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public final class Renderer {
    public static final int WIDTH = 480;
    public static final int HEIGHT = 320;
    private static final float BOARD_SCALE = 25f;
    private static final float BOARD_OFFSET = 22.5f;
    private static Renderer instance;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;

    private Renderer() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, WIDTH, HEIGHT);
        shapeRenderer = new ShapeRenderer();
    }

    public static Renderer getInstance() {
        if (instance == null) {
            instance = new Renderer();
        }
        return instance;
    }

    public void render() {
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Model model = Model.getInstance();
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (Cell cell : model.getBoard().getCells()) {
            switch (cell.getCellType()) {
                case COLLECTOR:
                    shapeRenderer.setColor(0.0f, 0.5f, 0.0f, 1.0f);
                    break;
                case CONTAINER:
                    shapeRenderer.setColor(0.0f, 0.0f, 0.5f, 1.0f);
                    break;
                case OBSTRUCTOR:
                    shapeRenderer.setColor(0.5f, 0.0f, 0.0f, 1.0f);
                    break;
                case SAFE:
                    shapeRenderer.setColor(0.5f, 0.5f, 0.0f, 1.0f);
                    break;
                case DUMMY:
                    shapeRenderer.setColor(0.0f, 0.0f, 0.0f, 1.0f);
                    break;
                default:
                    shapeRenderer.setColor(0.5f, 0.5f, 0.5f, 1.0f);
            }
            shapeRenderer.rect(cell.getX() * BOARD_SCALE + BOARD_OFFSET, cell.getY() * BOARD_SCALE + BOARD_OFFSET, BOARD_SCALE, BOARD_SCALE);
        }
        shapeRenderer.end();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(0.0f, 0.0f, 0.0f, 1.0f);
        for (Cell cell : model.getBoard().getCells()) {
            shapeRenderer.rect(cell.getX() * BOARD_SCALE + BOARD_OFFSET, cell.getY() * BOARD_SCALE + BOARD_OFFSET, BOARD_SCALE, BOARD_SCALE);
        }
        shapeRenderer.end();
    }

}
