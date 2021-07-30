package com.example.mentalhealth;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0012\u0010\u001a\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0010\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0012\u0010\u001f\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0012\u0010 \u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0012\u0010!\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0012\u0010\"\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0012\u0010#\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0012\u0010$\u001a\u00020%2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0012\u0010&\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0012\u0010'\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0014\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u0014\u0010)\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J\u001a\u0010*\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010+\u001a\u00020\u0018H\u0007J\u001a\u0010,\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010-\u001a\u00020\u0018H\u0007J\u001a\u0010.\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010/\u001a\u00020\u0018H\u0007J\u001a\u00100\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u00101\u001a\u00020\u001cH\u0007J\u001a\u00102\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u00101\u001a\u00020\u001cH\u0007J\u001c\u00103\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u00104\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u00105\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010-\u001a\u00020\u0018H\u0007J\u001a\u00106\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u00107\u001a\u00020\u0018H\u0007J\u001a\u00108\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u00101\u001a\u00020\u001cH\u0007J\u001a\u00109\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u00101\u001a\u00020\u001cH\u0007J\u001a\u0010:\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010-\u001a\u00020\u0018H\u0007J\u001a\u0010;\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010-\u001a\u00020\u0018H\u0007J!\u0010<\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010=\u001a\u0004\u0018\u00010\u001cH\u0007¢\u0006\u0002\u0010>J\u001c\u0010?\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010@\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010A\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010B\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/example/icfai_project/SharedPref/SaveSharedPreference;", "", "()V", "ATTENDANCE_CRITERIA", "", "BRANCH", "CHECKED_ITEM", "CLEARALL", "CLEARALL1", "COLLEGE", "COURSE", "DETAILS_UPLOADED", "POP", "PREF_USER_NAME", "REF", "REVIEW", "SEMESTER", "UNIT", "USER", "clearUserName", "", "ctx", "Landroid/content/Context;", "getAttendanceCriteria", "", "getBranch", "getCheckedItem", "getClearall", "", "getClearall1", "getCollege", "getCourse", "getPop", "getRef", "getReview", "getSemester", "getSharedPreferences", "Landroid/content/SharedPreferences;", "getUnit", "getUpload", "getUser", "getUserName", "setAttendanceCriteria", "attendance_criteria", "setBranch", "num", "setCheckedItem", "path", "setClearall", "value", "setClearall1", "setCollege", "college", "setCourse", "setPop", "pop", "setRef", "setRev", "setSemester", "setUnit", "setUploaded", "var", "(Landroid/content/Context;Ljava/lang/Boolean;)V", "setUser", "user", "setUserName", "userName", "app_debug"}, k = 1, mv = {1, 4, 2})
/* compiled from: SaveSharedPreference.kt */
public final class SaveSharedPreference {
    private static final String ATTENDANCE_CRITERIA = "attendance_criteria";
    private static final String BRANCH = "branch";
    private static final String CHECKED_ITEM = "checked_item";
    private static final String CLEARALL = "clearall";
    private static final String CLEARALL1 = "clearall1";
    private static final String DETAILS_UPLOADED = "uploaded";
    public static final SaveSharedPreference INSTANCE = new SaveSharedPreference();
    private static final String POP = "pop";
    private static final String PREF_USER_NAME = "username";
    private static final String REF = "com.connect.collegeconnect.MyPref";
    private static final String REVIEW = "review";
    private static final String UNIT = "unit";
    private static final String USER = "user";
    private static final String FingerPrint = "fingerprint";
    private static final String DP = "dp";
    private static final String Gender = "gender";
    private static final String Email = "email";

    private SaveSharedPreference() {
    }

    private final SharedPreferences getSharedPreferences(Context ctx) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "PreferenceManager.getDefaultSharedPreferences(ctx)");
        return defaultSharedPreferences;
    }

    @JvmStatic
    public static final void setUploaded(Context ctx, Boolean var) {
        SharedPreferences.Editor editor = INSTANCE.getSharedPreferences(ctx).edit();
        Intrinsics.checkNotNull(var);
        editor.putBoolean(DETAILS_UPLOADED, var.booleanValue());
        editor.apply();
    }

    @JvmStatic
    public static final void setUserName(Context ctx, String userName) {
        SharedPreferences.Editor editor = INSTANCE.getSharedPreferences(ctx).edit();
        editor.putString(PREF_USER_NAME, userName);
        editor.apply();
    }

    @JvmStatic
    public static final void setAge(Context ctx, String value) {
        SharedPreferences.Editor editor = INSTANCE.getSharedPreferences(ctx).edit();
        editor.putString(Email, value);
        editor.apply();
    }

    @JvmStatic
    public static final void setGender(Context ctx, String value) {
        SharedPreferences.Editor editor = INSTANCE.getSharedPreferences(ctx).edit();
        editor.putString(Gender, value);
        editor.apply();
    }
    @JvmStatic
    public static final void setDp(Context ctx, int value) {
        SharedPreferences.Editor editor = INSTANCE.getSharedPreferences(ctx).edit();
        editor.putInt(DP, value);
        editor.apply();
    }

    @JvmStatic
    public static final void setFingerPrint(Context ctx, Boolean finger) {
        SharedPreferences.Editor editor = INSTANCE.getSharedPreferences(ctx).edit();
        editor.putBoolean(PREF_USER_NAME, finger);
        editor.apply();
    }

    @JvmStatic
    public static final void setUser(Context ctx, String user) {
        SharedPreferences.Editor editor = INSTANCE.getSharedPreferences(ctx).edit();
        editor.putString(USER, user);
        editor.apply();
    }

    @JvmStatic
    public static final void setCheckedItem(Context ctx, int path) {
        SharedPreferences.Editor editor = INSTANCE.getSharedPreferences(ctx).edit();
        editor.putInt(CHECKED_ITEM, path);
        editor.apply();
    }


    @JvmStatic
    public static final void setBranch(Context ctx, int num) {
        SharedPreferences.Editor editor = INSTANCE.getSharedPreferences(ctx).edit();
        editor.putInt(BRANCH, num);
        editor.apply();
    }

    @JvmStatic
    public static final void setUnit(Context ctx, int num) {
        SharedPreferences.Editor editor = INSTANCE.getSharedPreferences(ctx).edit();
        editor.putInt(UNIT, num);
        editor.apply();
    }

    @JvmStatic
    public static final void setClearall(Context ctx, boolean value) {
        SharedPreferences.Editor editor = INSTANCE.getSharedPreferences(ctx).edit();
        editor.putBoolean(CLEARALL, value);
        editor.apply();
    }

    @JvmStatic
    public static final void setClearall1(Context ctx, boolean value) {
        SharedPreferences.Editor editor = INSTANCE.getSharedPreferences(ctx).edit();
        editor.putBoolean(CLEARALL1, value);
        editor.apply();
    }

    @JvmStatic
    public static final void setRef(Context ctx, boolean value) {
        SharedPreferences.Editor editor = INSTANCE.getSharedPreferences(ctx).edit();
        editor.putBoolean(REF, value);
        editor.apply();
    }

    @JvmStatic
    public static final void setAttendanceCriteria(Context ctx, int attendance_criteria) {
        SharedPreferences.Editor editor = INSTANCE.getSharedPreferences(ctx).edit();
        editor.putInt(ATTENDANCE_CRITERIA, attendance_criteria);
        editor.apply();
    }

    @JvmStatic
    public static final void setPop(Context ctx, int pop) {
        SharedPreferences.Editor editor = INSTANCE.getSharedPreferences(ctx).edit();
        editor.putInt(POP, pop);
        editor.apply();
    }

    @JvmStatic
    public static final void setRev(Context ctx, boolean value) {
        SharedPreferences.Editor editor = INSTANCE.getSharedPreferences(ctx).edit();
        editor.putBoolean(REVIEW, value);
        editor.apply();
    }

    public final int getAttendanceCriteria(Context ctx) {
        return getSharedPreferences(ctx).getInt(ATTENDANCE_CRITERIA, 75);
    }

    @JvmStatic
    public static final String getUserName(Context ctx) {
        return INSTANCE.getSharedPreferences(ctx).getString(PREF_USER_NAME, "");
    }

    @JvmStatic
    public static final Boolean getFingerPrint(Context ctx) {
        return INSTANCE.getSharedPreferences(ctx).getBoolean(FingerPrint, false);
    }

    @JvmStatic
    public static final String getUser(Context ctx) {
        return INSTANCE.getSharedPreferences(ctx).getString(USER, "");
    }

    @JvmStatic
    public static final int getDP(Context ctx) {
        return INSTANCE.getSharedPreferences(ctx).getInt(DP, 1);
    }

    @JvmStatic
    public static final String getEmail(Context ctx) {
        return INSTANCE.getSharedPreferences(ctx).getString(Email, "email");
    }
    @JvmStatic
    public static final String getGender(Context ctx) {
        return INSTANCE.getSharedPreferences(ctx).getString(DP, "email");
    }

    @JvmStatic
    public static final int getCheckedItem(Context ctx) {
        return INSTANCE.getSharedPreferences(ctx).getInt(CHECKED_ITEM, 2);
    }

    @JvmStatic
    public static final int getBranch(Context ctx) {
        return INSTANCE.getSharedPreferences(ctx).getInt(BRANCH, 0);
    }

    @JvmStatic
    public static final int getUnit(Context ctx) {
        return INSTANCE.getSharedPreferences(ctx).getInt(UNIT, 0);
    }

    @JvmStatic
    public static final boolean getClearall(Context ctx) {
        return INSTANCE.getSharedPreferences(ctx).getBoolean(CLEARALL, false);
    }

    public final boolean getClearall1(Context ctx) {
        return getSharedPreferences(ctx).getBoolean(CLEARALL1, false);
    }

    @JvmStatic
    public static final boolean getRef(Context ctx) {
        return INSTANCE.getSharedPreferences(ctx).getBoolean(REF, false);
    }

    @JvmStatic
    public static final boolean getUpload(Context ctx) {
        return INSTANCE.getSharedPreferences(ctx).getBoolean(DETAILS_UPLOADED, false);
    }

    @JvmStatic
    public static final int getPop(Context ctx) {
        return INSTANCE.getSharedPreferences(ctx).getInt(POP, 1);
    }

    @JvmStatic
    public static final boolean getReview(Context ctx) {
        return INSTANCE.getSharedPreferences(ctx).getBoolean(REVIEW, false);
    }

    @JvmStatic
    public static final void clearUserName(Context ctx) {
        SharedPreferences.Editor editor = INSTANCE.getSharedPreferences(ctx).edit();
        editor.remove(PREF_USER_NAME);
        editor.remove(USER);
        editor.remove(CHECKED_ITEM);
        editor.remove(BRANCH);
        editor.remove(CLEARALL1);
        editor.remove(CLEARALL);
        editor.remove(UNIT);
        editor.remove(ATTENDANCE_CRITERIA);
        editor.remove(REF);
        editor.apply();
    }
}
