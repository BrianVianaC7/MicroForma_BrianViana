package com.example.micropago_brianviana.ui.home.maps

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.TranslateAnimation
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.micropago_brianviana.R
import com.example.micropago_brianviana.databinding.FragmentMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapsFragment : Fragment(), GoogleMap.OnMyLocationClickListener {

    private var _binding: FragmentMapsBinding? = null
    private val binding get() = _binding!!
    private lateinit var map: GoogleMap
    private var currentMarker: Marker? = null

    //Animation
    private val moveLeft = TranslateAnimation(800f, 0f, 0f, 0f).apply {
        duration = 1500
    }
    private val moveRight = TranslateAnimation(0f, 800f, 0f, 0f).apply {
        duration = 1500
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initMap()
    }

    private fun initMap() {
        val mapFragment: SupportMapFragment =
            childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync { googleMap ->
            map = googleMap
            enableLocation()
            map.setOnMyLocationClickListener(this)
        }
    }

    private fun isLocationPermissionGranted() = ContextCompat.checkSelfPermission(
        requireContext(),
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    private fun enableLocation() {
        if (!::map.isInitialized) return
        if (isLocationPermissionGranted()) {
            map.isMyLocationEnabled = true
        } else {
            requestLocationPermission()
        }
    }

    private fun requestLocationPermission() {
        if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
            Toast.makeText(
                requireContext(),
                "Ve a ajustes y acepta los permisos",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            map.isMyLocationEnabled = true
        } else {
            Toast.makeText(
                requireContext(),
                "Para activar la localización ve a ajustes y acepta los permisos",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun createMarker(latLng: LatLng): Marker? {
        currentMarker?.isVisible = false
        val markerOptions = MarkerOptions().position(latLng).title("Mi ubicación")
        val marker = map.addMarker(markerOptions)
        if (marker != null) {
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(marker.position, 18f), 2000, null)
            currentMarker = marker
        }
        currentMarker?.isVisible = true
        return marker
    }


    override fun onMyLocationClick(p0: Location) {
        val latLng = LatLng(p0.latitude, p0.longitude)
        showAnimation(latLng.toString())
        createMarker(latLng)
    }

    private fun showAnimation(latLng: String) {
        binding.clLatlng.root.startAnimation(moveLeft)
        binding.clLatlng.root.visibility = View.VISIBLE
        binding.clLatlng.titlePopup.text = latLng
        binding.clLatlng.closeSnack.setOnClickListener {
            binding.clLatlng.root.startAnimation(moveRight)
            binding.clLatlng.root.visibility = View.GONE
        }
    }

    override fun onResume() {
        super.onResume()
        if (!::map.isInitialized) return
        if (!isLocationPermissionGranted()) {
            map.isMyLocationEnabled = false
            Toast.makeText(
                requireContext(),
                "Para activar la localización ve a ajustes y acepta los permisos",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}