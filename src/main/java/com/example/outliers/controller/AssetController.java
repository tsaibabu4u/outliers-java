package com.example.outliers.controller;

import com.example.outliers.model.Asset;
import com.example.outliers.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AssetController {
    private final AssetService assetService;

    @Autowired
    public AssetController(final AssetService assetService) {
        this.assetService = assetService;
    }

    /**
     * REST API to obtain all assets
     *
     * @return all of the assets as JSON
     */
    @GetMapping(value = "/assets", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Asset>> getAssets() {
        return ResponseEntity.ok(assetService.findAll());
    }

    /**
     * REST API to save new asset details
     *
     * @return all of the assets as JSON
     */
    @PostMapping(value = "/assets", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Asset> addAsset(@RequestBody Asset newAsset) {
        return ResponseEntity.ok(assetService.save(newAsset));
    }
    /**
     * REST API to update existing asset details
     *
     * @return all of the assets as JSON
     */
    @PatchMapping(value = "/assets/{assetId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Asset> updateAsset( @RequestBody Asset asset) {
        return ResponseEntity.ok(assetService.update(asset));
    }
    /**
     * REST API to obtain all asset ids
     *
     * @return all of the asset ids as JSON
     */
    @GetMapping(value = "/assetOutliers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Long>> getOutliersFromAssetAges() {
        return ResponseEntity.ok(assetService.findOutliersInAssetAge());
    }
}
