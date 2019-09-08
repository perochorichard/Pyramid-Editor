document.addEventListener('DOMContentLoaded', function (event) {
    let camera, scene, renderer;
    let width, height;
    let cone;
    const scale = 3;
    const pyramidScale = 4;

    function init() {
        width = window.innerWidth;
        height = window.innerHeight;
        let aspect = width * scale / height;

        // set container
        // var container = document.createElement('div');
        // document.body.appendChild(container);
        // ^^ above method would show the renderer on the bottom, since script waits for DOM to load
        let container = document.getElementById("display");

        // set scene
        scene = new THREE.Scene();

        // Create Pyramid
        const geometry = new THREE.ConeGeometry(pyramidScale * 10, pyramidScale * 20, baseN);
        const material = new THREE.MeshBasicMaterial({color: 0x77BFCE});
        material.wireframe = true;
        material.wireframeLinewidth = 30;
        cone = new THREE.Mesh(geometry, material);
        scene.add(cone);

        // create camera
        camera = new THREE.PerspectiveCamera(35, aspect, 0.1, 1000);
        camera.position.y = 160;
        camera.position.z = 100; // move camera out to prevent being inside the pyramid
        camera.lookAt(cone.position);

        // create renderer
        renderer = new THREE.WebGLRenderer();
        renderer.setSize(width, height / scale);
        container.appendChild(renderer.domElement);
    }

// get runtime clock
    const clock = new THREE.Clock();

// updates pyramid
    function animate() {
        requestAnimationFrame(animate);

        cone.rotation.y -= clock.getDelta();

        renderer.render(scene, camera);
    }

// accommodate for window resize
    window.onresize = function () {
        width = window.innerWidth;
        height = window.innerHeight;
        camera.aspect = width * scale / height;
        camera.updateProjectionMatrix();
        renderer.setSize(width, height / scale);
        renderer.render(scene, camera);
    }

    init();
    animate();
})
