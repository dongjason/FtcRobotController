package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * StickyGamepad provides methods to track the "rising edge" of gamepad button presses
 * (the moment when a button changes from not-pressed to pressed) and maintains button states.
 */
public class StickyGamepad {
    private Gamepad gamepad;
    
    // Current values
    public boolean dpad_up, dpad_down, dpad_left, dpad_right;
    public boolean a, b, x, y;
    public boolean left_bumper, right_bumper;
    public boolean left_stick_button, right_stick_button;
    public boolean back, guide, start;
    
    // Previous values
    private boolean prev_dpad_up, prev_dpad_down, prev_dpad_left, prev_dpad_right;
    private boolean prev_a, prev_b, prev_x, prev_y;
    private boolean prev_left_bumper, prev_right_bumper;
    private boolean prev_left_stick_button, prev_right_stick_button;
    private boolean prev_back, prev_guide, prev_start;
    
    /**
     * Constructor for StickyGamepad
     * @param gamepad The gamepad to track
     */
    public StickyGamepad(Gamepad gamepad) {
        this.gamepad = gamepad;
    }
    
    /**
     * Updates the current and previous button states.
     * Call this ONCE at the beginning of each loop iteration.
     */
    public void update() {
        // Save current as previous
        prev_dpad_up = dpad_up;
        prev_dpad_down = dpad_down;
        prev_dpad_left = dpad_left;
        prev_dpad_right = dpad_right;
        prev_a = a;
        prev_b = b;
        prev_x = x;
        prev_y = y;
        prev_left_bumper = left_bumper;
        prev_right_bumper = right_bumper;
        prev_left_stick_button = left_stick_button;
        prev_right_stick_button = right_stick_button;
        prev_back = back;
        prev_guide = guide;
        prev_start = start;
        
        // Update current button states
        dpad_up = gamepad.dpad_up;
        dpad_down = gamepad.dpad_down;
        dpad_left = gamepad.dpad_left;
        dpad_right = gamepad.dpad_right;
        a = gamepad.a;
        b = gamepad.b;
        x = gamepad.x;
        y = gamepad.y;
        left_bumper = gamepad.left_bumper;
        right_bumper = gamepad.right_bumper;
        left_stick_button = gamepad.left_stick_button;
        right_stick_button = gamepad.right_stick_button;
        back = gamepad.back;
        guide = gamepad.guide;
        start = gamepad.start;
    }

    /**
     * Returns true if the button is currently pressed
     */
    public boolean getButton(ButtonType button) {
        switch (button) {
            case DPAD_UP: return dpad_up;
            case DPAD_DOWN: return dpad_down;
            case DPAD_LEFT: return dpad_left;
            case DPAD_RIGHT: return dpad_right;
            case A: return a;
            case B: return b;
            case X: return x;
            case Y: return y;
            case LEFT_BUMPER: return left_bumper;
            case RIGHT_BUMPER: return right_bumper;
            case LEFT_STICK_BUTTON: return left_stick_button;
            case RIGHT_STICK_BUTTON: return right_stick_button;
            case BACK: return back;
            case GUIDE: return guide;
            case START: return start;
            default: return false;
        }
    }

    /**
     * Returns true if the button was pressed this update but not last update (rising edge)
     */
    public boolean getButtonPress(ButtonType button) {
        switch (button) {
            case DPAD_UP: return dpad_up && !prev_dpad_up;
            case DPAD_DOWN: return dpad_down && !prev_dpad_down;
            case DPAD_LEFT: return dpad_left && !prev_dpad_left;
            case DPAD_RIGHT: return dpad_right && !prev_dpad_right;
            case A: return a && !prev_a;
            case B: return b && !prev_b;
            case X: return x && !prev_x;
            case Y: return y && !prev_y;
            case LEFT_BUMPER: return left_bumper && !prev_left_bumper;
            case RIGHT_BUMPER: return right_bumper && !prev_right_bumper;
            case LEFT_STICK_BUTTON: return left_stick_button && !prev_left_stick_button;
            case RIGHT_STICK_BUTTON: return right_stick_button && !prev_right_stick_button;
            case BACK: return back && !prev_back;
            case GUIDE: return guide && !prev_guide;
            case START: return start && !prev_start;
            default: return false;
        }
    }

    /**
     * Returns true if the button was released this update but pressed last update (falling edge)
     */
    public boolean getButtonRelease(ButtonType button) {
        switch (button) {
            case DPAD_UP: return !dpad_up && prev_dpad_up;
            case DPAD_DOWN: return !dpad_down && prev_dpad_down;
            case DPAD_LEFT: return !dpad_left && prev_dpad_left;
            case DPAD_RIGHT: return !dpad_right && prev_dpad_right;
            case A: return !a && prev_a;
            case B: return !b && prev_b;
            case X: return !x && prev_x;
            case Y: return !y && prev_y;
            case LEFT_BUMPER: return !left_bumper && prev_left_bumper;
            case RIGHT_BUMPER: return !right_bumper && prev_right_bumper;
            case LEFT_STICK_BUTTON: return !left_stick_button && prev_left_stick_button;
            case RIGHT_STICK_BUTTON: return !right_stick_button && prev_right_stick_button;
            case BACK: return !back && prev_back;
            case GUIDE: return !guide && prev_guide;
            case START: return !start && prev_start;
            default: return false;
        }
    }

    /**
     * Enum for all gamepad buttons
     */
    public enum ButtonType {
        DPAD_UP,
        DPAD_DOWN,
        DPAD_LEFT,
        DPAD_RIGHT,
        A,
        B,
        X,
        Y,
        LEFT_BUMPER,
        RIGHT_BUMPER,
        LEFT_STICK_BUTTON,
        RIGHT_STICK_BUTTON,
        BACK,
        GUIDE,
        START
    }
}