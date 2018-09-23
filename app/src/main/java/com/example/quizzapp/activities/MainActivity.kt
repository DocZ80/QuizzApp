package com.example.quizzapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.quizzapp.R
import com.example.quizzapp.utilities.AppUtilities
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IProfile
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity() {

    lateinit var header: AccountHeader
    lateinit var drawer: Drawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        val profile: IProfile<*> = ProfileDrawerItem().withIcon(R.mipmap.ic_launcher)

        header = AccountHeaderBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(true)
                .withHeaderBackground(R.drawable.header)
                .withOnAccountHeaderProfileImageListener(object : AccountHeader.OnAccountHeaderProfileImageListener {
                    override fun onProfileImageClick(view: View?, profile: IProfile<*>?, current: Boolean): Boolean {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onProfileImageLongClick(view: View?, profile: IProfile<*>?, current: Boolean): Boolean {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
                .addProfiles(profile)
                .build()

        drawer = DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withHasStableIds(true)
                .withAccountHeader(header)
                .addDrawerItems(
                        PrimaryDrawerItem().withName("About App")
                                .withIcon(R.drawable.ic_menu_manage)
                                .withIdentifier(10)
                                .withSelectable(false),
                        PrimaryDrawerItem().withName("Youtube")
                                .withIcon(R.drawable.ic_menu_camera)
                                .withIdentifier(20)
                                .withSelectable(false),
                        PrimaryDrawerItem().withName("facebook")
                                .withIcon(R.drawable.ic_menu_camera)
                                .withIdentifier(20)
                                .withSelectable(false),
                        DividerDrawerItem(),
                        PrimaryDrawerItem().withName("Options")
                                .withIcon(R.drawable.ic_menu_camera)
                                .withIdentifier(30)
                                .withSelectable(false),
                        PrimaryDrawerItem().withName("Share App")
                                .withIcon(R.drawable.ic_menu_camera)
                                .withIdentifier(31)
                                .withSelectable(false),
                        PrimaryDrawerItem().withName("Agreement")
                                .withIcon(R.drawable.ic_menu_camera)
                                .withIdentifier(32)
                                .withSelectable(false)
                                .withOnDrawerItemClickListener { view, position, drawerItem ->
                                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                }

                )
                .withSavedInstance(savedInstanceState)
                .withShowDrawerOnFirstLaunch(false)
                .withShowDrawerUntilDraggedOpened(true)
                .build()

    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen) {
            drawer.closeDrawer()
        } else {
            AppUtilities.tapPromptToExit(this)
        }
    }
}
